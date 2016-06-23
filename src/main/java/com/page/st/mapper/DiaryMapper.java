package com.page.st.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.page.st.entity.Diary;


@Service
public interface DiaryMapper {
	
	
//	public int addDiary(SqlSession ss,Diary diary){
//
//		
//		return ss.insert("Diary.addDiary", diary);
//
//		
//	}
	
	public int addDiary(Diary diary);
	
	
//	public Diary getDiaryDetailById(SqlSession ss,int diaryId){
//
//		
//		return ss.selectOne("Diary.getDiaryDetailById", diaryId);
//
//		
//	}
	
	public Diary getDiaryDetailById(int diaryId);
	
//	public int editDiary(SqlSession ss,Diary diary){
//
//		
//		return ss.update("Diary.editDiary", diary);
//
//		
//	}
	
	public int editDiary(Diary diary);

}
