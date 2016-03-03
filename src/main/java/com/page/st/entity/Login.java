package com.page.st.entity;

import java.io.Serializable;
import java.sql.Timestamp;


public class Login  extends BaseEntity  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6036318877837460874L;
	
	private int id;
	private int userId;
	private String type;
	private String value;
	private String password;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
