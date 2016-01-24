package com.page.st.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.page.st.entity.User;
import com.page.st.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/finduser")
	public void findUser() {
		
		System.out.println("-----execute----");
		
		User user = userService.getUserById("123");
		
		System.out.println("resuslt=="+user);
		
	}

}
