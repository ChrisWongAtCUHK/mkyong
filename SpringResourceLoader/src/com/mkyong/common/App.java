package com.mkyong.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

// http://www.mkyong.com/spring/spring-resource-loader-with-getresource-example/
public class App {
	public static void main(String[] ars){
		ApplicationContext appContext = 
		    	   new ClassPathXmlApplicationContext(new String[] {"If-you-have-any.xml"});
		Resource resource = 
		           appContext.getResource("classpath:com/mkyong/common/testing.txt");
		try{
	     	  InputStream is = resource.getInputStream();
	          BufferedReader br = new BufferedReader(new InputStreamReader(is));
	 
	          String line;
	          while ((line = br.readLine()) != null) {
	             System.out.println(line);
	       	  } 
	          br.close();
	 
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}
	 
	    }
}
