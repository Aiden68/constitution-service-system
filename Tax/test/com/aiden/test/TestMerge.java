package com.aiden.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.aiden.test.entity.Person;
import com.aiden.test.service.TestService;


public class TestMerge {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void loadCtx(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	@Test
	public void testSpring(){
		TestService ts = (TestService)ctx.getBean("testService");
		ts.say();
	}
	
	@Test
	public void testHibernate(){
		if(ctx==null){
			System.out.println("null");
		}
		SessionFactory sf = (SessionFactory)ctx.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(new Person("人员1"));
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testServiceAndDao(){
		TestService ts = (TestService)ctx.getBean("testService");
//		ts.save(new Person("person2"));
		Person person = ts.findPerson("297efdc45964d668015964d669f90000");
		System.out.println(person.getName());
	}
	
	@Test
	public void testTransactionReadOnly(){
		TestService ts = (TestService)ctx.getBean("testService");
//			ts.save(new Person("person2"));
		Person person = ts.findPerson("297efdc45964d668015964d669f90000");
		System.out.println(person.getName());
	}
	
	@Test
	public void testTransactionRollback(){
		TestService ts = (TestService)ctx.getBean("testService");
		ts.save(new Person("person4"));
	}
}
