package com.page.st.vo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterForm {
	
	@NotNull
	@Size(min=2, max=30)
	private String userName;

	@Size(min=6, max=150)
    private String email;

    @Size(min=11, max=11)
    private String mobile;
    
    @Size(min=6, max=30)
    private String password;
    
    @Size(min=6, max=30)
    private String password2;

   
    


	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getPassword2() {
		return password2;
	}



	public void setPassword2(String password2) {
		this.password2 = password2;
	}



	public String toString() {
        return "RegisterForm(Name: " + this.userName + ", mobile: " + this.mobile + ")";
    }
}
