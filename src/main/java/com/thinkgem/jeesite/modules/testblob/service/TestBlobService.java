/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testblob.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.testblob.entity.TestBlob;
import com.thinkgem.jeesite.modules.testblob.dao.TestBlobDao;

/**
 * 测试BLOBService
 * @author 胡庆东
 * @version 2016-11-25
 */
@Service
@Transactional(readOnly = true)
public class TestBlobService extends CrudService<TestBlobDao, TestBlob> {

	public TestBlob get(String id) {
		TestBlob testBlob=super.get(id);
//		testBlob.setBlobCol(Encodes.decodeBase64String(testBlob.getBlobCol()));
		return testBlob;
	}
	
	public List<TestBlob> findList(TestBlob testBlob) {
		return super.findList(testBlob);
	}
	
	public Page<TestBlob> findPage(Page<TestBlob> page, TestBlob testBlob) {
		return super.findPage(page, testBlob);
	}
	
	@Transactional(readOnly = false)
	public void save(TestBlob testBlob) {
//		testBlob.setBlobCol(Encodes.encodeBase64(testBlob.getBlobCol()));
		super.save(testBlob);
	}
	
	@Transactional(readOnly = false)
	public void delete(TestBlob testBlob) {
		super.delete(testBlob);
	}
	
}