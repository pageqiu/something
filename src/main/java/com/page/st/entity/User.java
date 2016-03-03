package com.page.st.entity;

import java.io.Serializable;
import java.sql.Timestamp;


public class User  extends BaseEntity  implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6036318877837460874L;
	
	private int id;
	private String name;
	private String userName;
	private String sex;
	private String certNo;
	private String email;
	private String mobile;
	private String province;
	private String city;
	private String district;
	private String nowProvince;
	private String nowCity;
	private String nowDistrict;
	private String university;
	private String seniorSchool;
	private String juniorSchool;
	private String primarySchool;
	private String kindergarten;
	private String company;
	private String company2;
	




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
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
	
	



	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}





	public String getNowProvince() {
		return nowProvince;
	}



	public void setNowProvince(String nowProvince) {
		this.nowProvince = nowProvince;
	}



	public String getNowCity() {
		return nowCity;
	}



	public void setNowCity(String nowCity) {
		this.nowCity = nowCity;
	}



	public String getNowDistrict() {
		return nowDistrict;
	}



	public void setNowDistrict(String nowDistrict) {
		this.nowDistrict = nowDistrict;
	}



	public String getUniversity() {
		return university;
	}



	public void setUniversity(String university) {
		this.university = university;
	}



	public String getSeniorSchool() {
		return seniorSchool;
	}



	public void setSeniorSchool(String seniorSchool) {
		this.seniorSchool = seniorSchool;
	}



	public String getJuniorSchool() {
		return juniorSchool;
	}



	public void setJuniorSchool(String juniorSchool) {
		this.juniorSchool = juniorSchool;
	}



	public String getPrimarySchool() {
		return primarySchool;
	}



	public void setPrimarySchool(String primarySchool) {
		this.primarySchool = primarySchool;
	}



	public String getKindergarten() {
		return kindergarten;
	}



	public void setKindergarten(String kindergarten) {
		this.kindergarten = kindergarten;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getCompany2() {
		return company2;
	}



	public void setCompany2(String company2) {
		this.company2 = company2;
	}



	public String toString() {
		
		return "id:"+id+" userName:"+name;
	}


}
