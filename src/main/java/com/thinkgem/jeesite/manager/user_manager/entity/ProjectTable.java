/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.manager.user_manager.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 项目管理Entity
 * @author 胡庆东
 * @version 2016-11-08
 */
public class ProjectTable extends DataEntity<ProjectTable> {
	
	private static final long serialVersionUID = 1L;
	private String projectName;		// 项目名称
	private String projectManager;		// 项目经理
	
	public ProjectTable() {
		super();
	}

	public ProjectTable(String id){
		super(id);
	}

	@Length(min=1, max=64, message="项目名称长度必须介于 1 和 64 之间")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Length(min=0, max=64, message="项目经理长度必须介于 0 和 64 之间")
	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	
}