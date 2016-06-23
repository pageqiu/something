package com.page.st.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.page.st.common.Constants;
import com.page.st.config.MyBatisConfiguration;
import com.page.st.entity.Login;
import com.page.st.entity.User;
import com.page.st.mapper.LoginMapper;
import com.page.st.mapper.UserDao;
import com.page.st.util.BaseValueUtil;
import com.page.st.util.CheckUtil;

@Service
public class UserService {
	
	@Autowired
	private MyBatisConfiguration repository;
	

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginMapper loginMapper;
	
	public User getUserById(int id) {
		
		SqlSessionFactory factory = repository.getSqlSessionFactory();
		SqlSession ss = factory.openSession();
		
		User user= userDao.getUserById(ss, id);
		ss.clearCache();
		ss.close();
		return user;
	}
	
	public int register(User user,List<Login> listLogin) {
		
		SqlSessionFactory factory = repository.getSqlSessionFactory();
		SqlSession ss = factory.openSession();
        
		BaseValueUtil.setCreateBaseEntityValue(user);
		
		
		int key = userDao.addUser(ss, user);
		
		for(int i=0; i<listLogin.size();i++) {
			listLogin.get(i).setUserId(user.getId());
		}
		
		int num = userDao.addLogin(ss, listLogin);
		
		ss.clearCache();
		ss.close();
		return num;

	}
	
	public Login login(String loginName,String password) {
		
//		SqlSessionFactory factory = repository.getSqlSessionFactory();
//		SqlSession ss = factory.openSession();
		
		String type = null;
		if(CheckUtil.checkEmail(loginName)) {
			type=Constants.TYPE_EMAIL;
		} else if(CheckUtil.isMobileNO(loginName)) {
			type=Constants.TYPE_MOBILE;
		} else {
			type=Constants.TYPE_USER_NAME;
		}
		
		Login login = new Login();
		login.setType(type);
		login.setValue(loginName);
		login.setPassword(password);
		
		Login l =loginMapper.getLoginInfo(login);
		
		//Login l = userDao.getLogin(ss, login);
//
//		ss.clearCache();
//		ss.close();
		
 		return l;
	}


}
