package com.aiden.nsfw.role.dao;

import com.aiden.core.dao.BaseDao;
import com.aiden.nsfw.role.entity.Role;

public interface RoleDao extends BaseDao<Role>{

	void deleteRolePrivilegeByRoleId(String roleId);

}
