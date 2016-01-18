package com.page.st.mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.page.st.config.MyBatisConfiguration;
import com.page.st.entity.User;

@Service
public class UserDao {
	
	@Autowired
	private MyBatisConfiguration repository;

	
	
	public User getUserById(String id){
		
		SqlSessionFactory ssf = repository.sqlSessionFactory();
		
		SqlSession ss = ssf.openSession();
		
		ss.selectOne("User.getUserById", "123");
		
		return null;
		
	}

}
