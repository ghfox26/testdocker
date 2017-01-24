/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testblob.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 测试BLOBEntity
 * 
 * @author 胡庆东
 * @version 2016-11-25
 */
public class TestBlob extends DataEntity<TestBlob> {

	private static final long serialVersionUID = 1L;
	private String name; // name
	private String blobCol; // blob_col
	private String textCol; // text_col

	public TestBlob() {
		super();
	}

	public TestBlob(String id) {
		super(id);
	}

	@Length(min = 0, max = 60, message = "name长度必须介于 0 和 60 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBlobCol() {
		/*
		 * if (null != blobCol){ return Encodes.decodeBase64String(blobCol);
		 * }else{ return ""; }
		 */
		return blobCol;
	}

	public void setBlobCol(String blobCol) {
		/*
		 * if (null != blobCol){ this.blobCol = Encodes.encodeBase64(blobCol);
		 * }else{ this.blobCol =""; }
		 */
		this.blobCol = blobCol;
	}

	public String getTextCol() {
		return textCol;
	}

	public void setTextCol(String textCol) {
		this.textCol = textCol;
	}

}