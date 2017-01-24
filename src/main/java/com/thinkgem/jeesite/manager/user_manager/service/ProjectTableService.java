/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.manager.user_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.manager.user_manager.entity.ProjectTable;
import com.thinkgem.jeesite.manager.user_manager.dao.ProjectTableDao;

/**
 * 项目管理Service
 * @author 胡庆东
 * @version 2016-11-08
 */
@Service
@Transactional(readOnly = true)
public class ProjectTableService extends CrudService<ProjectTableDao, ProjectTable> {

	public ProjectTable get(String id) {
		return super.get(id);
	}
	
	public List<ProjectTable> findList(ProjectTable projectTable) {
		return super.findList(projectTable);
	}
	
	public Page<ProjectTable> findPage(Page<ProjectTable> page, ProjectTable projectTable) {
		return super.findPage(page, projectTable);
	}
	
	@Transactional(readOnly = false)
	public void save(ProjectTable projectTable) {
		super.save(projectTable);
	}
	
	@Transactional(readOnly = false)
	public void delete(ProjectTable projectTable) {
		super.delete(projectTable);
	}
	
}