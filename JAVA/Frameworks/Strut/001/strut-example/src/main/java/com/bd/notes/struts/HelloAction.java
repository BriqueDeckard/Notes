package com.bd.notes.struts;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action("/hello")
@Result(name = "success", location = "/results.jsp")
public class HelloAction {

	private String firstName;

	public String execute() {
		System.out.println("Value of firstname is: " + this.firstName);

		return "success";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
