package com.page.st.entity;

import java.io.Serializable;


public class Diary extends BaseEntity implements Serializable  {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3004545855906370395L;
	private int diaryId;
	private int userId;
	private String title;
	private String context;



	public String getTitle() {
		return title;
	}





	public void setTitle(String title) {
		this.title = title;
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





	public String toString() {
		
		return "diartyId:"+diaryId+" userId:"+userId;
	}
}
