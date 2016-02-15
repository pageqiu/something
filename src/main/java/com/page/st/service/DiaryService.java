package com.page.st.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
		
		SqlSessionFactory factory = repository.getSqlSessionFactory();
		SqlSession ss = factory.openSession();

		int num = diaryDao.addDiary(ss, diary);
		
		ss.clearCache();
		ss.close();
		return num;
	}


}
