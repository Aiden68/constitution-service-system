package com.aiden.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aiden.core.dao.BaseDao;
import com.aiden.core.page.PageResult;
import com.aiden.core.util.QueryHelper;

public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements
		BaseDao<T> {
	
	Class<T> clazz;
	
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>)pt.getActualTypeArguments()[0];
	}
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(entity);
	}
	
	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(entity);
	}
	
	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(findObjectById(id));
	}
	
	@Override
	public T findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(clazz, id);
	}
	
	@Override
	public List<T> findObjects() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("FROM " + clazz.getSimpleName());
		return query.list();
	}
	
	@Override
	public List<T> findObjects(String hql, List<Object> parameters) {
		Query query = getSession().createQuery(hql);
		if(parameters != null){
			for(int i = 0; i < parameters.size(); i++){
				query.setParameter(i, parameters.get(i));
			}
		}
		return query.list();
	}

	@Override
	public List<T> findObjects(QueryHelper queryHelper) {
		Query query = getSession().createQuery(queryHelper.getQueryListHql());
		List<Object> parameters = queryHelper.getParameters();
		if(parameters != null){
			for(int i = 0; i < parameters.size(); i++){
				query.setParameter(i, parameters.get(i));
			}
		}
		return query.list();
	}

	@Override
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		Query query = getSession().createQuery(queryHelper.getQueryListHql());
		List<Object> parameters = queryHelper.getParameters();
		if(parameters != null){
			for(int i = 0; i < parameters.size(); i++){
				query.setParameter(i, parameters.get(i));
			}
		}
		if(pageNo < 1) pageNo = 1;
		query.setFirstResult((pageNo-1)*pageSize);//设置数据起始索引号
		query.setMaxResults(pageSize);
		List items = query.list();
		//获取总记录数
		Query queryCount = getSession().createQuery(queryHelper.getQueryCountHql());
		if(parameters != null){
			for(int i = 0; i < parameters.size(); i++){
				queryCount.setParameter(i, parameters.get(i));
			}
		}
		long totalCount = (Long)queryCount.uniqueResult();
		
		return new PageResult(totalCount, pageNo, pageSize, items);
	}
}
