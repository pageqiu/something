package com.page.st.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.page.st.entity.Statistics;

@Service
public class StatisticsDao {
	
	
	public List<Statistics> getStatisticsAll(SqlSession ss){

		
		return ss.selectList("Statistics.getStatisticsAll");
	}

}
