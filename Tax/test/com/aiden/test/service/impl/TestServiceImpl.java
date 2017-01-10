package com.aiden.test.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiden.test.dao.TestDao;
import com.aiden.test.entity.Person;
import com.aiden.test.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {
	@Resource
	TestDao testDao;
	@Override
	public void say() {
		// TODO Auto-generated method stub
		System.out.println("service saying hi.");
	}

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		testDao.save(person);
//		int i = 1 / 0;
	}

	@Override
	public Person findPerson(Serializable id) {
		// TODO Auto-generated method stub
		return testDao.findPerson(id);
	}

}
