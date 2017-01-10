package com.aiden.test.dao;

import java.io.Serializable;

import com.aiden.test.entity.Person;

public interface TestDao {
	//save person
		public void save(Person person);
		
		//retrive person by id
		public Person findPerson(Serializable id);
}
