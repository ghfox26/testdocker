/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testblob.web;

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
import com.thinkgem.jeesite.modules.testblob.entity.TestBlob;
import com.thinkgem.jeesite.modules.testblob.service.TestBlobService;

/**
 * 测试BLOBController
 * @author 胡庆东
 * @version 2016-11-25
 */
@Controller
@RequestMapping(value = "${adminPath}/testblob/testBlob")
public class TestBlobController extends BaseController {

	@Autowired
	private TestBlobService testBlobService;
	
	@ModelAttribute
	public TestBlob get(@RequestParam(required=false) String id) {
		TestBlob entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = testBlobService.get(id);
		}
		if (entity == null){
			entity = new TestBlob();
		}
		return entity;
	}
	
	@RequiresPermissions("testblob:testBlob:view")
	@RequestMapping(value = {"list", ""})
	public String list(TestBlob testBlob, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TestBlob> page = testBlobService.findPage(new Page<TestBlob>(request, response), testBlob); 
		model.addAttribute("page", page);
		return "modules/testblob/testBlobList";
	}

	@RequiresPermissions("testblob:testBlob:view")
	@RequestMapping(value = "form")
	public String form(TestBlob testBlob, Model model) {
		model.addAttribute("testBlob", testBlob);
		return "modules/testblob/testBlobForm";
	}

	@RequiresPermissions("testblob:testBlob:edit")
	@RequestMapping(value = "save")
	public String save(TestBlob testBlob, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, testBlob)){
			return form(testBlob, model);
		}
		testBlobService.save(testBlob);
		addMessage(redirectAttributes, "保存BLOB成功");
		return "redirect:"+Global.getAdminPath()+"/testblob/testBlob/?repage";
	}
	
	@RequiresPermissions("testblob:testBlob:edit")
	@RequestMapping(value = "delete")
	public String delete(TestBlob testBlob, RedirectAttributes redirectAttributes) {
		testBlobService.delete(testBlob);
		addMessage(redirectAttributes, "删除BLOB成功");
		return "redirect:"+Global.getAdminPath()+"/testblob/testBlob/?repage";
	}

}