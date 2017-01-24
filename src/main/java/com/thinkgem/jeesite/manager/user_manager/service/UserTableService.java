/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.manager.user_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.manager.user_manager.entity.UserTable;
import com.thinkgem.jeesite.manager.user_manager.dao.UserTableDao;

/**
 * 员工管理Service
 * @author huqd
 * @version 2016-11-07
 */
@Service
@Transactional(readOnly = true)
public class UserTableService extends CrudService<UserTableDao, UserTable> {

	public UserTable get(String id) {
		return super.get(id);
	}
	
	public List<UserTable> findList(UserTable userTable) {
		return super.findList(userTable);
	}
	
	public Page<UserTable> findPage(Page<UserTable> page, UserTable userTable) {
		return super.findPage(page, userTable);
	}
	
	@Transactional(readOnly = false)
	public void save(UserTable userTable) {
		super.save(userTable);
	}
	
	@Transactional(readOnly = false)
	public void delete(UserTable userTable) {
		super.delete(userTable);
	}
	
}