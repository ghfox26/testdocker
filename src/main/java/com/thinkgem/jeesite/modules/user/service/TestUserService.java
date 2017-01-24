/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.user.entity.TestUser;
import com.thinkgem.jeesite.modules.user.dao.TestUserDao;

/**
 * 测试用户Service
 * @author 胡庆东
 * @version 2017-01-23
 */
@Service
@Transactional(readOnly = true)
public class TestUserService extends CrudService<TestUserDao, TestUser> {

	public TestUser get(String id) {
		return super.get(id);
	}
	
	public List<TestUser> findList(TestUser testUser) {
		return super.findList(testUser);
	}
	
	public Page<TestUser> findPage(Page<TestUser> page, TestUser testUser) {
		return super.findPage(page, testUser);
	}
	
	@Transactional(readOnly = false)
	public void save(TestUser testUser) {
		super.save(testUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestUser testUser) {
		super.delete(testUser);
	}
	
}