package com.acvrock.dao;

import com.acvrock.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class PersonDao {
	
	@Autowired
	StringRedisTemplate stringRedisTemplate; //1
	
	@Resource(name="stringRedisTemplate")
	ValueOperations<String,String> valOpsStr; //3
	
	
	public void stringRedisTemplateDemo(){ //5
		valOpsStr.set("xx", "yy");
	}
	
	public String getString(){//7
		return valOpsStr.get("xx");
	}
	
	////////////////////////////////////////////////////
	
	@Autowired
	RedisTemplate<Object, Object> redisTemplate; //2
	
	@Resource(name="redisTemplate")
	ValueOperations<Object, Object> valOps; //4
	
	
	public void save(Person person){ //6
		valOps.set(person.getId(),person);
	}
	
	public Person getPerson(){//8
		return (Person) valOps.get("1");
	}

}
