package com.aiden.core.permission.impl;

import java.util.List;

import javax.annotation.Resource;

import com.aiden.core.permission.PermissionCheck;
import com.aiden.nsfw.role.entity.Role;
import com.aiden.nsfw.role.entity.RolePrivilege;
import com.aiden.nsfw.user.entity.User;
import com.aiden.nsfw.user.entity.UserRole;
import com.aiden.nsfw.user.service.UserService;

public class PermissionCheckImpl implements PermissionCheck{

	@Resource
	private UserService userService;

	@Override
	public boolean isAccessible(User user, String code) {
		//1、获取用户的所有角色
		List<UserRole> list = user.getUserRoles();
		if(list == null){
			list = userService.getUserRolesByUserId(user.getId());
		}
		
		//2、根据每个角色对于的所有权限进行对比
		if(list != null && list.size()>0){
			for(UserRole ur: list){
				Role role = ur.getId().getRole();
				for(RolePrivilege rp: role.getRolePrivileges()){
					//对比是否有code对应的权限
					if(code.equals(rp.getId().getCode())){
						//说明有权限，返回true
						return true;
					}
				}
			}
		}
		return false;
	}

}
