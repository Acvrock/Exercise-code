package com.acvrock.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

@Document //1 映射领域模型和MongoDB的文档
public class Person {
	@Id //2 此属性为文档的Id
	private String id;
	private String name;
	private Integer age;
	@Field("locs") //此属性在文档中的名称为locs,以数组方式存放locations信息
	private Collection<Location> locations =  new LinkedHashSet<Location>();
	

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Collection<Location> getLocations() {
		return locations;
	}

	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}
	

}
