/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.revisited.microservice.employee.bean;

import java.io.Serializable;

/**
 * @author Vishnu Garg
 * @created On Aug 18, 2018
 *
 */
public class Employee implements Serializable{
	private static final long serialVersionUID = -3970206781360313502L;
	String name;
	String address;
	String cls;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee(int id,String name, String address, String cls) {
		super();
		this.id=id;
		this.name = name;
		this.address = address;
		this.cls = cls;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCls() {
		return cls;
	}
}
