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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.page.st.entity.Diary;
import com.page.st.entity.Statistics;
import com.page.st.entity.Summary;
import com.page.st.entity.User;
import com.page.st.service.DiaryService;
import com.page.st.service.StatisticsService;
import com.page.st.service.SummaryService;
import com.page.st.service.UserService;
import com.page.st.vo.DiaryForm;
import com.page.st.vo.PersonForm;
import com.page.st.vo.RegisterForm;
import com.page.st.vo.SummaryForm;


@Controller
public class DiaryController extends WebMvcConfigurerAdapter {
	
	private static Logger log = LoggerFactory.getLogger(DiaryController.class);  
	
	@Autowired
	private DiaryService diaryService;
	
	@Autowired
	private UserService userService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    
    @RequestMapping(value="/gotoDiaryDetail", method=RequestMethod.GET)
    public String gotoDiaryDetail(@RequestParam(required=true) int diaryId,Model model) {
    	
    	log.error("--diartyId--"+diaryId);
    	Diary diary = diaryService.gotoDiaryDetail(diaryId);
    	
    	model.addAttribute("diary", diary);
    	
        return "diarydetail";
    }
    
    @RequestMapping(value="/gotoEditDiary", method=RequestMethod.GET)
    public String gotoEditDiary(@RequestParam(required=true) int diaryId,Model model) {
    	
    	log.error("--diartyId--"+diaryId);
     	Diary diary = diaryService.gotoDiaryDetail(diaryId);
//    	
    	model.addAttribute("diary", diary);
    	
        return "editDiary";
    }
    
    
    @RequestMapping(value="/editDiary", method=RequestMethod.POST)
    public String editDiary(@Valid DiaryForm diaryForm, BindingResult bindingResult, Model model) {
    	
    	log.error("--diaryForm-"+diaryForm);
    	Diary diary = new Diary();
    	diary.setDiaryId(Integer.valueOf(diaryForm.getDiaryId()));
    	diary.setContext(diaryForm.getJournaling());
    			
     	int num  = diaryService.editDiary(diary);
//    	
    	model.addAttribute("diary", diary);
    	
        return "editDiary";
    }

//    @RequestMapping(value="/test1", method=RequestMethod.POST)
//    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult,Model model) {
//    	log.error("-----test1");
//        if (bindingResult.hasErrors()) {
//            return "form";
//        }
//        
//        User user = userService.getUserById(Integer.valueOf(personForm.getId()));
//       // model.addAttribute("name", user.getName());
//		
//		log.error("resuslt=="+user);
//
//        return "redirect:findesummarys";
//    }

}
