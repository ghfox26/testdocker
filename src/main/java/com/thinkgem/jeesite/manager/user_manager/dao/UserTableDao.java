/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.manager.user_manager.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.manager.user_manager.entity.UserTable;

/**
 * 员工管理DAO接口
 * @author huqd
 * @version 2016-11-07
 */
@MyBatisDao
public interface UserTableDao extends CrudDao<UserTable> {
	
}