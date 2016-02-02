package com.page.st.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.page.st.entity.BaseEntity;

public class BaseValueUtil {
	
	
	public static void setCreateBaseEntityValue(BaseEntity entity) {
		
		if(entity ==null) {
			return;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Calendar cl = Calendar.getInstance();
		
		entity.setCreatePerson("");
		entity.setUpdatePerson("");
		entity.setCreateTime(Timestamp.valueOf(sdf.format(cl.getTime())));
		entity.setUpdateTime(Timestamp.valueOf(sdf.format(cl.getTime())));
		entity.setSeqNo(0);
	}
	

}
