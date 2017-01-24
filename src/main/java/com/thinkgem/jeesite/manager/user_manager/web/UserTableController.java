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
import com.thinkgem.jeesite.manager.user_manager.entity.UserTable;
import com.thinkgem.jeesite.manager.user_manager.service.UserTableService;

/**
 * 员工管理Controller
 * @author huqd
 * @version 2016-11-07
 */
@Controller
@RequestMapping(value = "${adminPath}/user_manager/userTable")
public class UserTableController extends BaseController {

	@Autowired
	private UserTableService userTableService;
	
	@ModelAttribute
	public UserTable get(@RequestParam(required=false) String id) {
		UserTable entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = userTableService.get(id);
		}
		if (entity == null){
			entity = new UserTable();
		}
		return entity;
	}
	
	@RequiresPermissions("user_manager:userTable:view")
	@RequestMapping(value = {"list", ""})
	public String list(UserTable userTable, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<UserTable> page = userTableService.findPage(new Page<UserTable>(request, response), userTable); 
		model.addAttribute("page", page);
		return "manager/user_manager/userTableList";
	}

	@RequiresPermissions("user_manager:userTable:view")
	@RequestMapping(value = "form")
	public String form(UserTable userTable, Model model) {
		model.addAttribute("userTable", userTable);
		return "manager/user_manager/userTableForm";
	}

	@RequiresPermissions("user_manager:userTable:edit")
	@RequestMapping(value = "save")
	public String save(UserTable userTable, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, userTable)){
			return form(userTable, model);
		}
		userTableService.save(userTable);
		addMessage(redirectAttributes, "保存员工成功");
		return "redirect:"+Global.getAdminPath()+"/user_manager/userTable/?repage";
	}
	
	@RequiresPermissions("user_manager:userTable:edit")
	@RequestMapping(value = "delete")
	public String delete(UserTable userTable, RedirectAttributes redirectAttributes) {
		userTableService.delete(userTable);
		addMessage(redirectAttributes, "删除员工成功");
		return "redirect:"+Global.getAdminPath()+"/user_manager/userTable/?repage";
	}

}