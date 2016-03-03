package com.page.st.control;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.util.StringUtils;

import com.page.st.entity.Login;
import com.page.st.entity.User;
import com.page.st.service.UserService;
import com.page.st.vo.RegisterForm;

@Controller
public class UserController extends WebMvcConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/register").setViewName("register");
	}

	@RequestMapping("/finduser")
	public void findUser() {

		System.out.println("-----execute----");

		User user = userService.getUserById(123);

		System.out.println("resuslt==" + user);

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showForm(RegisterForm personForm) {
		return "register";
	}

	@RequestMapping("/register")
	public String register(@Valid RegisterForm registerForm, BindingResult bindingResult) {

		System.out.println("-----execute----");

		if (bindingResult.hasErrors()) {
			return "register";
		}

		User user = new User();
		BeanUtils.copyProperties(registerForm, user);

		Login login = null;
		List<Login> list = new ArrayList<Login>();

		if (!StringUtils.isEmpty(registerForm.getUserName())) {
			login = new Login();
			login.setType("10");
			login.setValue(registerForm.getUserName());
			login.setPassword(registerForm.getPassword());
			list.add(login);
		}

		if (!StringUtils.isEmpty(registerForm.getEmail())) {
			login = new Login();
			login.setType("20");
			login.setValue(registerForm.getEmail());
			login.setPassword(registerForm.getPassword());
			list.add(login);
		}

		if (!StringUtils.isEmpty(registerForm.getMobile())) {
			login = new Login();
			login.setType("30");
			login.setValue(registerForm.getMobile());
			login.setPassword(registerForm.getPassword());
			list.add(login);
		}

		userService.register(user, list);

		System.out.println("resuslt==" + registerForm.getEmail());
		return "redirect:/register";

	}

}
