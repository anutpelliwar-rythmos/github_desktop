package com.example.demo.model;

import java.io.Serializable;

public class Student  implements Serializable{
	private static final long serialVersionUID=-740885147914600032L;
	
	private static String id;
	private static String name;
	private static String school;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
		
	}
	public String toString() {
		// TODO Auto-generated method stub
		return "Student[id="+id+",name="+name+",school="+ school+"]";
	}	

}
