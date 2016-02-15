package com.page.st.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.page.st.config.MyBatisConfiguration;
import com.page.st.entity.User;
import com.page.st.mapper.UserDao;

@Service
public class UserService {
	
	@Autowired
	private MyBatisConfiguration repository;
	

	@Autowired
	private UserDao userDao;
	
	public User getUserById(String id) {
		
		SqlSessionFactory factory = repository.getSqlSessionFactory();
		SqlSession ss = factory.openSession();
		
		return userDao.getUserById(ss, id);
	}


}
