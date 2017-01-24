/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.manager.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 部门管理Entity
 * @author 胡庆东
 * @version 2016-11-21
 */
public class DepartmentTable extends DataEntity<DepartmentTable> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 部门名称
	
	public DepartmentTable() {
		super();
	}

	public DepartmentTable(String id){
		super(id);
	}

	@Length(min=1, max=64, message="部门名称长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}