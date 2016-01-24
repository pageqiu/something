package com.page.st.service;

import org.apache.ibatis.session.SqlSession;
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
		
		SqlSession ss = repository.getSqlSession();
		
		return userDao.getUserById(ss, id);
	}


}
