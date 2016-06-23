package com.page.st.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.page.st.entity.Login;
import com.page.st.entity.User;

@Service
public class UserDao {
	
	
	public User getUserById(SqlSession ss,int id){

		
		return ss.selectOne("User.getUserById", id);

		
	}
	
	public int addUser(SqlSession ss,User user){

		
		return ss.insert("User.addUser", user);

		
	}
	
	public int addLogin(SqlSession ss,List<Login> login){

		
		return ss.insert("User.addLogin", login);

		
	}
	
//	public Login getLogin(SqlSession ss,Login login){
//		
//		return ss.selectOne("Login.getLoginInfo", login);
//	}

}
