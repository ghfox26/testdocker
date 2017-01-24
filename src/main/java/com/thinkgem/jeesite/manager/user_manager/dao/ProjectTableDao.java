/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.manager.user_manager.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.manager.user_manager.entity.ProjectTable;

/**
 * 项目管理DAO接口
 * @author 胡庆东
 * @version 2016-11-08
 */
@MyBatisDao
public interface ProjectTableDao extends CrudDao<ProjectTable> {
	
}