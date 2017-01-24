/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.user.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.user.entity.TestUser;

/**
 * 测试用户DAO接口
 * @author 胡庆东
 * @version 2017-01-23
 */
@MyBatisDao
public interface TestUserDao extends CrudDao<TestUser> {
	
}