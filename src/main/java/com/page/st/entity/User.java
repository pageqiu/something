package com.page.st.entity;

import java.io.Serializable;


public class User implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6036318877837460874L;
	
	private String id;
	private String name;
	private String sex;
	private String certNo;
	private String email;
	private String mobile;
	
	
	
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



	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getCertNo() {
		return certNo;
	}



	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String toString() {
		
		return "id:"+id+" userName:"+name;
	}


}
