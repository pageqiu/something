package com.page.st.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.page.st.entity.Diary;


@Service
public class DiaryDao {
	
	
	public int addDiary(SqlSession ss,Diary diary){

		
		return ss.insert("Diary.addDiary", diary);

		
	}
	
	public Diary getDiaryDetailById(SqlSession ss,int diaryId){

		
		return ss.selectOne("Diary.getDiaryDetailById", diaryId);

		
	}
	
	public int editDiary(SqlSession ss,Diary diary){

		
		return ss.update("Diary.editDiary", diary);

		
	}

}
