package com.page.st.entity;

import java.io.Serializable;


public class Summary implements Serializable  {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3004545855906370395L;
	
	private int diaryId;
	private String title;
	private String context;

	
	
	public int getDiaryId() {
		return diaryId;
	}



	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}



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



	public String toString() {
		
		return "title:"+title+" context:"+context;
	}
	
	
	

}
