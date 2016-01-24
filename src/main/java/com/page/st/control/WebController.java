package com.page.st.control;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.page.st.entity.User;
import com.page.st.service.UserService;
import com.page.st.vo.PersonForm;


@Controller
public class WebController extends WebMvcConfigurerAdapter {
	
	private static Logger log = LoggerFactory.getLogger(WebController.class);  
	
	@Autowired
	private UserService userService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @RequestMapping(value="/test0", method=RequestMethod.GET)
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @RequestMapping(value="/test1", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult,Model model) {
    	log.error("-----test1");
        if (bindingResult.hasErrors()) {
            return "form";
        }
        
        User user = userService.getUserById(personForm.getId());
        model.addAttribute("name", user.getUserName());
		
		log.error("resuslt=="+user);

        return "form";
    }
}
