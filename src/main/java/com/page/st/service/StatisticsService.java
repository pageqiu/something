package com.page.st.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.page.st.config.MyBatisConfiguration;
import com.page.st.entity.Statistics;
import com.page.st.entity.User;
import com.page.st.mapper.StatisticsDao;
import com.page.st.mapper.UserDao;

@Service
public class StatisticsService {
	
	@Autowired
	private MyBatisConfiguration repository;
	

	@Autowired
	private StatisticsDao statisticsDao;
	
	public List<Statistics> getStatisticsAll() {
		
		SqlSessionFactory factory = repository.getSqlSessionFactory();
		SqlSession ss = factory.openSession();
		List<Statistics> list = statisticsDao.getStatisticsAll(ss);
		ss.clearCache();
		ss.close();
		
		return list;
	}

}
