package com.dgr.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * It is a note that is specified on the class to publish the class as a web service
 */
@WebService
public class HelloWebService {
	
	/**
	 * Exposure methods will be released
	 * @param name
	 * @return
	 */
	public String HelloService1(String name){
		return "Hello :" + name;
	}
	
	/**
	 * This method is not released after adding @WebMethod(exclude=true)
	 * @param name
	 * @return
	 */
	@WebMethod(exclude=true)
	public String HelloService2(String name){
		return "Hello" + name;
	}
	
	/**
	 * Static methods will not be released
	 * @param name
	 * @return
	 */
	public static String HelloService3(String name){
		return "GoodBye" + name;
	}
	
	public static void main(String[] args){
		String address = "http://localhost:8080/WevService2";
		Endpoint.publish(address,new HelloWebService());
		System.out.println("Release success");
	}
}
