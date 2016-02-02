package com.page.st.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.page.st.config.MyBatisConfiguration;
import com.page.st.entity.Diary;
import com.page.st.entity.User;
import com.page.st.mapper.DiaryDao;
import com.page.st.mapper.UserDao;

@Service
public class DiaryService {
	
	@Autowired
	private MyBatisConfiguration repository;
	

	@Autowired
	private DiaryDao diaryDao;
	
	public int addDiary(Diary diary) {
		
		SqlSession ss = repository.getSqlSession();
		
		return diaryDao.addDiary(ss, diary);
	}


}
