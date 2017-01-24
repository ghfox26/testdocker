/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.manager.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.manager.entity.DepartmentTable;

/**
 * 部门管理DAO接口
 * @author 胡庆东
 * @version 2016-11-21
 */
@MyBatisDao
public interface DepartmentTableDao extends CrudDao<DepartmentTable> {
	
}