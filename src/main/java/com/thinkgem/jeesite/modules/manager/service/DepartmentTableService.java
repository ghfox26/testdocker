/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.manager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.manager.entity.DepartmentTable;
import com.thinkgem.jeesite.modules.manager.dao.DepartmentTableDao;

/**
 * 部门管理Service
 * @author 胡庆东
 * @version 2016-11-21
 */
@Service
@Transactional(readOnly = true)
public class DepartmentTableService extends CrudService<DepartmentTableDao, DepartmentTable> {

	public DepartmentTable get(String id) {
		return super.get(id);
	}
	
	public List<DepartmentTable> findList(DepartmentTable departmentTable) {
		return super.findList(departmentTable);
	}
	
	public Page<DepartmentTable> findPage(Page<DepartmentTable> page, DepartmentTable departmentTable) {
		return super.findPage(page, departmentTable);
	}
	
	@Transactional(readOnly = false)
	public void save(DepartmentTable departmentTable) {
		super.save(departmentTable);
	}
	
	@Transactional(readOnly = false)
	public void delete(DepartmentTable departmentTable) {
		super.delete(departmentTable);
	}
	
}