package com.page.st.control;

import java.util.ArrayList;
import java.util.List;

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

import com.page.st.entity.Statistics;
import com.page.st.entity.Summary;
import com.page.st.entity.User;
import com.page.st.service.StatisticsService;
import com.page.st.service.SummaryService;
import com.page.st.service.UserService;
import com.page.st.vo.PersonForm;
import com.page.st.vo.SummaryForm;


@Controller
public class WebController extends WebMvcConfigurerAdapter {
	
	private static Logger log = LoggerFactory.getLogger(WebController.class);  
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SummaryService summaryService;
	
	@Autowired
	private StatisticsService statisticsService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @RequestMapping(value="/test0", method=RequestMethod.GET)
    public String showForm(PersonForm personForm) {
        return "form";
    }
    
    @RequestMapping(value="/test2", method=RequestMethod.GET)
    public String test2() {
        return "fileUpLoad";
    }

    @RequestMapping(value="/test1", method=RequestMethod.POST)
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult,Model model) {
    	log.error("-----test1");
        if (bindingResult.hasErrors()) {
            return "form";
        }
        
        User user = userService.getUserById(personForm.getId());
       // model.addAttribute("name", user.getName());
		
		log.error("resuslt=="+user);

        return "redirect:findesummarys";
    }
    @RequestMapping(value="/findesummarys", method=RequestMethod.GET)
    public String findsummarys(@Valid SummaryForm summaryForm, BindingResult bindingResult,Model model) {
    	log.error("-----findesummarys=-----");
        if (bindingResult.hasErrors()) {
            return "form";
        }
        
        List<Summary> list = summaryService.getAllSummarys();
        model.addAttribute("summarys", list);
		log.error("resuslt=="+list);
		
		List<Statistics> statisticsList = statisticsService.getStatisticsAll();
		
		List<String> provinceList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		
		if(statisticsList != null) {
			for(int i=0;i < statisticsList.size(); i++) {
				provinceList.add(statisticsList.get(i).getProvince());
				valueList.add(String.valueOf(statisticsList.get(i).getStatistics()));
			}
		}
		
		model.addAttribute("provinceList", provinceList);
		model.addAttribute("valueList", valueList);

        return "first";
    }
}
