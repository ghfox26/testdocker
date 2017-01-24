/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.testblob.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.testblob.entity.TestBlob;

/**
 * 测试BLOBDAO接口
 * @author 胡庆东
 * @version 2016-11-25
 */
@MyBatisDao
public interface TestBlobDao extends CrudDao<TestBlob> {
	
}