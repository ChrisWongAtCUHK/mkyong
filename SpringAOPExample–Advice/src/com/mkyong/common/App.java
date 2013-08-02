package com.mkyong.common;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
 
import com.mkyong.customer.services.*;
 
// http://www.mkyong.com/spring/spring-aop-examples-advice/
// http://openhome.cc/Gossip/SpringGossip/AroundAdvice.html
// TODO: CGLIB2 
public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new FileSystemXmlApplicationContext(
				new String[] { "Spring-Customer.xml" });
 
		//CustomerService cust = (CustomerService) appContext.getBean("customerService");
		ICustomerService cust = 
                (ICustomerService) appContext.getBean("customerServiceProxy");
 
		System.out.println("*************************");
		cust.printName();
		System.out.println("*************************");
		cust.printURL();
		System.out.println("*************************");
		try {
			cust.printThrowException();
		} catch (Exception e) {
 
		}
 
	}
}