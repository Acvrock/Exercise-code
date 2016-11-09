package com.acvrock;

import com.acvrock.dao.PersonRepository;
import com.acvrock.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Ch104Application.class) //1 这两个都可以
@ContextConfiguration(classes = Ch104Application.class)
@WebAppConfiguration
@Transactional //2 每次测试后的数据都会回滚
public class Ch104ApplicationTests {
	@Autowired
	PersonRepository personRepository;
	
	MockMvc mvc;
	
	@Autowired 
	WebApplicationContext webApplicationContext;
	
	String expectedJson;
	
	@Before //3  初始化工作，如准备数据等
	public void setUp() throws JsonProcessingException{ 
		Person p1 = new Person("wyf");
		Person p2 = new Person("wisely");
		personRepository.save(p1);
		personRepository.save(p2);
		
		expectedJson =Obj2Json(personRepository.findAll()); //4
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		
	}
	
	protected String Obj2Json(Object obj) throws JsonProcessingException{//5
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	
	@Test
	public void testPersonController() throws Exception {
		String uri="/person";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
																.andReturn(); //6
		int status = result.getResponse().getStatus(); //7
		String content = result.getResponse().getContentAsString(); //8
		
		Assert.assertEquals("错误，正确的返回值为200",200, status); //9
		Assert.assertEquals("错误，返回值和预期返回值不一致", expectedJson,content); //10
	}

	
	//在Eclipse 的 Junit控制台查看测试结果
}
