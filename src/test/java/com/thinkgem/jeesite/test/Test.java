package com.thinkgem.jeesite.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.common.utils.Encodes;
import com.thinkgem.jeesite.modules.gen.entity.GenTable;
import com.thinkgem.jeesite.modules.gen.service.GenTableService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/spring-context*.xml" })

public class Test {

	public static void main(String[] args) {

	}

	private GenTableService genTableService;

	private static final Logger logger = Logger.getLogger(Test.class);

	public GenTableService getGenTableService() {
		return genTableService;
	}

	@Autowired
	public void setGenTableService(GenTableService genTableService) {
		this.genTableService = genTableService;
	}
	/*private static SerializerFeature[] features = {SerializerFeature.WriteNullNumberAsZero, 
			SerializerFeature.IgnoreNonFieldGetter,SerializerFeature.NotWriteDefaultValue,
			SerializerFeature.WriteNullListAsEmpty,
			SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteMapNullValue,
			SerializerFeature.WriteNullStringAsEmpty};  */
	@org.junit.Test
	public void test1() {
		List<GenTable> l = genTableService.findTableListFormDb(new GenTable());
		// logger.debug("genTableService.findTableListFormDb:"+l);
		// logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd
		// HH:mm:ss"));
		// logger.debug(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd
		// HH:mm:ss"));
		// logger.debug("JSON:"+JSON.toJSONString(l,
		// SerializerFeature.PrettyFormat));
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(l);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("jackson:" + json);
		List<Data> d=new ArrayList<Data>();
		for(GenTable t:l){
			Data data=new Data();
			data.name=t.getName();
			data.comments=t.getComments();
			//logger.debug(data.name+":"+data.comments);
			d.add(data);
		}
		try {
			//json = JSON.toJSONString(d,SerializerFeature.WriteNullStringAsEmpty);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("fastjson1:" + json);
		try {
			//json = JSON.toJSONString(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("fastjson2:" + json);

	}
	class Data{
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		String name;
		String comments;
		String reab;
		public String getReab() {
			return reab;
		}
		public void setReab(String reab) {
			this.reab = reab;
		}
	}
	@org.junit.Test
	public void test2() {
		String str=Encodes.encodeBase64("计时结束");
		logger.debug("encode:"+str);
		String str1=Encodes.decodeBase64String(str);
		logger.debug("decode:"+str1);
		//String[] map={"key1","value1"};
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("key1","value1");
		map.put("key2","value2");
		map.put("key3","value3");
		map.put("key4","value4");
		map.put("key5","value5");
		String json = JSON.toJSONString(map);
		logger.debug("json:"+json);
		Set<String> set=map.keySet();  
        System.out.println("jSonmap集合中所有元素是：");  
        Iterator<String> it=set.iterator();  
        while (it.hasNext()){  
            String key=(String) it.next();  
            String name=(String) map.get(key);  
            System.out.println(key+" "+name);  
        }  Map<String, ?> jSonmap=JSON.parseObject(json);
		json = JSON.toJSONString(jSonmap);
		logger.debug("jSonmap:"+json);
		set=jSonmap.keySet();  
        System.out.println("jSonmap集合中所有元素是：");  
        it=set.iterator();  
        while (it.hasNext()){  
            String key=(String) it.next();  
            String name=(String) jSonmap.get(key);  
            System.out.println(key+" "+name);  
        }  
	}
}
