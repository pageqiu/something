package com.page.st.entity;

import java.io.Serializable;
import java.sql.Timestamp;


public class Diary extends BaseEntity implements Serializable  {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3004545855906370395L;
	private int diaryId;
	private int userId;
	private String context;
	private Timestamp eventTs;
	private String eventWhere;
	private String province;
	private String city;
	private String district;
	private String street;
	private String village;
	
	public Timestamp getEventTs() {
		return eventTs;
	}





	public void setEventTs(Timestamp eventTs) {
		this.eventTs = eventTs;
	}





	public String getEventWhere() {
		return eventWhere;
	}





	public void setEventWhere(String eventWhere) {
		this.eventWhere = eventWhere;
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





	public String getContext() {
		return context;
	}





	public void setContext(String context) {
		this.context = context;
	}





	public int getDiaryId() {
		return diaryId;
	}





	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}





	public int getUserId() {
		return userId;
	}





	public void setUserId(int userId) {
		this.userId = userId;
	}





	public String getStreet() {
		return street;
	}





	public void setStreet(String street) {
		this.street = street;
	}



	public String getVillage() {
		return village;
	}





	public void setVillage(String village) {
		this.village = village;
	}





	public String toString() {
		
		return "diartyId:"+diaryId+" userId:"+userId;
	}
}
