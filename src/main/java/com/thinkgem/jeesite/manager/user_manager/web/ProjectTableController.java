/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.manager.user_manager.web;

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
import com.thinkgem.jeesite.manager.user_manager.entity.ProjectTable;
import com.thinkgem.jeesite.manager.user_manager.service.ProjectTableService;

/**
 * 项目管理Controller
 * @author 胡庆东
 * @version 2016-11-08
 */
@Controller
@RequestMapping(value = "${adminPath}/user_manager/projectTable")
public class ProjectTableController extends BaseController {

	@Autowired
	private ProjectTableService projectTableService;
	
	@ModelAttribute
	public ProjectTable get(@RequestParam(required=false) String id) {
		ProjectTable entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = projectTableService.get(id);
		}
		if (entity == null){
			entity = new ProjectTable();
		}
		return entity;
	}
	
	@RequiresPermissions("user_manager:projectTable:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProjectTable projectTable, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ProjectTable> page = projectTableService.findPage(new Page<ProjectTable>(request, response), projectTable); 
		model.addAttribute("page", page);
		return "manager/user_manager/projectTableList";
	}

	@RequiresPermissions("user_manager:projectTable:view")
	@RequestMapping(value = "form")
	public String form(ProjectTable projectTable, Model model) {
		model.addAttribute("projectTable", projectTable);
		return "manager/user_manager/projectTableForm";
	}

	@RequiresPermissions("user_manager:projectTable:edit")
	@RequestMapping(value = "save")
	public String save(ProjectTable projectTable, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, projectTable)){
			return form(projectTable, model);
		}
		projectTableService.save(projectTable);
		addMessage(redirectAttributes, "保存项目成功");
		return "redirect:"+Global.getAdminPath()+"/user_manager/projectTable/?repage";
	}
	
	@RequiresPermissions("user_manager:projectTable:edit")
	@RequestMapping(value = "delete")
	public String delete(ProjectTable projectTable, RedirectAttributes redirectAttributes) {
		projectTableService.delete(projectTable);
		addMessage(redirectAttributes, "删除项目成功");
		return "redirect:"+Global.getAdminPath()+"/user_manager/projectTable/?repage";
	}

}