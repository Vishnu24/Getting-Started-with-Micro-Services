/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.revisited.microservice.employee.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.revisited.microservice.employee.bean.Employee;

/**
 * @author Vishnu Garg
 * @created On Aug 18, 2018
 *
 */
@Component
@RestController
public class EmployeeController {
	private Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
    RestTemplate restTemplate;
	private static final Map<Integer, Employee> employeeData = new HashMap<Integer, Employee>();

	static {
		employeeData.put(111, new Employee(111, "Employee1", "Delhi", "NA"));
		employeeData.put(222, new Employee(222, "Employee2", "Delhi", "NA"));
	}

	@RequestMapping(value = "/echoEmployeeName/{name}")
	public String echoEmployeeName(@PathVariable(name = "name") String name) {
		LOGGER.info("------ In echoEmployeeName ------");
		return "hello  <strong style=\"color: red;\">" + name + " </strong> Responsed on : " + new Date();
	}

	@RequestMapping(value = "/getEmployeeDetails/{name}")
	public Employee getStudentDetails(@PathVariable(name = "name") String name) {
		LOGGER.info("------ In getStudentDetails ------");
		return new Employee(1, name, "Pune", "MCA");
	}

	@RequestMapping(value = "/findEmployeeDetails/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployeeDetails(@PathVariable int employeeId) {
		System.out.println("Getting Employee details for " + employeeId);
		Employee employee = employeeData.get(employeeId);
		if (employee == null) {
			employee = new Employee(1, "ABC", "Delhi", "N/A");
		}
		return employee;
	}

	/*
	 * For Logging using ELK
	 */
	@RequestMapping(value = "/exception")
	public String exception() {
		String rsp = "";
		try {
			int i = 1 / 0;
			// should get exception
		} catch (Exception e) {
			e.printStackTrace();

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString(); // stack trace as a string
			LOGGER.error("Exception As String :: - > " + sStackTrace);
			rsp = sStackTrace;
		}
		return rsp;
	}
	
	
	 @HystrixCommand(fallbackMethod = "callEmployeeServiceAndGetData_Fallback")
	    public String callEmployeeServiceAndGetData(String employeeName) {
	 
	        System.out.println("Getting Employee details for " + employeeName);
	        String result = restTemplate.getForObject("http://192.168.1.8082", String.class);
	        String response = "Response fro Other Servo"+result;
	 
	        System.out.println("Response Received as " + response + " -  " + new Date());
	 
	        return "NORMAL FLOW !!! - Employee Name -  " + employeeName + " :::  " +
	                    " Employe Details " + response + " -  " + new Date();
	    }
	     
	    @SuppressWarnings("unused")
	    private String callStudentServiceAndGetData_Fallback(String schoolname) {
	 
	        System.out.println("Student Service is down!!! fallback route enabled...");
	        return "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. " +
	                    " Service will be back shortly - " + new Date();
	    }
	 
	
}
