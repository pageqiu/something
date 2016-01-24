package com.page.st.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.page.st.entity.User;

@Service
public class UserDao {
	
	
	public User getUserById(SqlSession ss,String id){

		
		return ss.selectOne("User.getUserById", id);

		
	}

}
