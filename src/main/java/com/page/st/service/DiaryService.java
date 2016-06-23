package com.page.st.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.page.st.entity.Diary;
import com.page.st.mapper.DiaryMapper;

@Service
public class DiaryService {
	
//	@Autowired
//	private MyBatisConfiguration repository;
	

	@Autowired
	private DiaryMapper diaryDao;
	
	public int addDiary(Diary diary) {
		
//		SqlSessionFactory factory = repository.getSqlSessionFactory();
//		SqlSession ss = factory.openSession();

		int num = diaryDao.addDiary(diary);
		
//		ss.clearCache();
//		ss.close();
		return num;
	}
	
	public Diary gotoDiaryDetail(int diaryId) {
		
//		SqlSessionFactory factory = repository.getSqlSessionFactory();
//		SqlSession ss = factory.openSession();

		Diary diary = diaryDao.getDiaryDetailById(diaryId);
//
//		ss.clearCache();
//		ss.close();
		return diary;
	}
	
	
	public int editDiary(Diary diary) {
//		
//		SqlSessionFactory factory = repository.getSqlSessionFactory();
//		SqlSession ss = factory.openSession();

		int num = diaryDao.editDiary(diary);

//		ss.clearCache();
//		ss.close();
		return num;
	}


}
