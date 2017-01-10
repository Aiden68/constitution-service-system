package com.aiden.core.dao;

import java.io.Serializable;
import java.util.List;

import com.aiden.core.page.PageResult;
import com.aiden.core.util.QueryHelper;

public interface BaseDao<T> {
	//新增
	public void save(T entity);
	//更新
	public void update(T entity);
	//delete
	public void delete(Serializable id);
	//retrive
	public T findObjectById(Serializable id);
	//retrive return list
	public List<T> findObjects();
	//条件查询列表
	public List<T> findObjects(String hql, List<Object> parameters);
	
	public List<T> findObjects(QueryHelper queryHelper);
	
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize);
	
}
