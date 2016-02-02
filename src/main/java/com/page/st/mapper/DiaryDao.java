package com.page.st.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.page.st.entity.Diary;


@Service
public class DiaryDao {
	
	
	public int addDiary(SqlSession ss,Diary diary){

		
		return ss.insert("Diary.addDiary", diary);

		
	}

}
