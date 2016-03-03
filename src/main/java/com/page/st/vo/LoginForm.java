package com.page.st.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {
	
	@NotNull
    private String loginName;

	@NotNull
    private String password;

  

    public String getLoginName() {
		return loginName;
	}



	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String toString() {
        return "LoginForm(Name: " + this.loginName + ", password: " + this.password + ")";
    }
}
