package com.aiden.nsfw.role.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.aiden.core.dao.impl.BaseDaoImpl;
import com.aiden.nsfw.role.dao.RoleDao;
import com.aiden.nsfw.role.entity.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("DELETE FROM RolePrivilege WHERE id.role.roleId = ?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}
	
}
