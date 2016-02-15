package com.page.st.entity;

import java.io.Serializable;


public class Statistics  extends BaseEntity implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String province;
	private int statistics;

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}

	

	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public int getStatistics() {
		return statistics;
	}



	public void setStatistics(int statistics) {
		this.statistics = statistics;
	}



	public String toString() {
		
		return "id:"+id+" province:"+province+" statistics:"+statistics;
	}


}
