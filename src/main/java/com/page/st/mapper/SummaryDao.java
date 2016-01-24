package com.page.st.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.page.st.entity.Summary;


@Service
public class SummaryDao {
	
	
	public List<Summary> getAllSummarys(SqlSession ss){

		
		return ss.selectList("Summary.getAllSummarys");

		
	}

}
