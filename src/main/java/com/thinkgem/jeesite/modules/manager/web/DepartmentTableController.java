/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.manager.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.manager.entity.DepartmentTable;
import com.thinkgem.jeesite.modules.manager.service.DepartmentTableService;

/**
 * 部门管理Controller
 * @author 胡庆东
 * @version 2016-11-21
 */
@Controller
@RequestMapping(value = "${adminPath}/manager/departmentTable")
public class DepartmentTableController extends BaseController {

	@Autowired
	private DepartmentTableService departmentTableService;
	
	@ModelAttribute
	public DepartmentTable get(@RequestParam(required=false) String id) {
		DepartmentTable entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = departmentTableService.get(id);
		}
		if (entity == null){
			entity = new DepartmentTable();
		}
		return entity;
	}
	
	@RequiresPermissions("manager:departmentTable:view")
	@RequestMapping(value = {"list", ""})
	public String list(DepartmentTable departmentTable, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<DepartmentTable> page = departmentTableService.findPage(new Page<DepartmentTable>(request, response), departmentTable); 
		model.addAttribute("page", page);
		return "modules/manager/departmentTableList";
	}

	@RequiresPermissions("manager:departmentTable:view")
	@RequestMapping(value = "form")
	public String form(DepartmentTable departmentTable, Model model) {
		model.addAttribute("departmentTable", departmentTable);
		return "modules/manager/departmentTableForm";
	}

	@RequiresPermissions("manager:departmentTable:edit")
	@RequestMapping(value = "save")
	public String save(DepartmentTable departmentTable, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, departmentTable)){
			return form(departmentTable, model);
		}
		departmentTableService.save(departmentTable);
		addMessage(redirectAttributes, "保存部门成功");
		return "redirect:"+Global.getAdminPath()+"/manager/departmentTable/?repage";
	}
	
	@RequiresPermissions("manager:departmentTable:edit")
	@RequestMapping(value = "delete")
	public String delete(DepartmentTable departmentTable, RedirectAttributes redirectAttributes) {
		departmentTableService.delete(departmentTable);
		addMessage(redirectAttributes, "删除部门成功");
		return "redirect:"+Global.getAdminPath()+"/manager/departmentTable/?repage";
	}

}