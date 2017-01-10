package com.aiden.test.service;

import java.io.Serializable;

import com.aiden.test.entity.Person;

public interface TestService {
	
	public void say();
	
	//save person
	public void save(Person person);
	
	//retrive person by id
	public Person findPerson(Serializable id);
}
