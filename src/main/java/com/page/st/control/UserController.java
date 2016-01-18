package com.page.st.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.page.st.entity.User;
import com.page.st.mapper.UserDao;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/finduser")
	public void findUser() {
		
		System.out.println("-----execute----");
		
		User user = userDao.getUserById("1234");
		
		System.out.println("resuslt=="+user);
		
	}

}
