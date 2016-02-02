package com.page.st.control;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.page.st.entity.Diary;
import com.page.st.service.DiaryService;
import com.page.st.util.BaseValueUtil;
import com.page.st.util.IdentifyingCode;

@Controller
@SessionAttributes("codeImge")
public class FileUploadController {
	
	private static Logger log = LoggerFactory.getLogger(WebController.class);  
	
	private final String UPLOAD_PATH="D:/upload/";
	
	@Autowired
	private DiaryService diaryService;

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }
    
    @RequestMapping(value="/getCode", method=RequestMethod.GET)
    public @ResponseBody void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	
    	//设置不缓存图片  
        response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "No-cache");  
        response.setDateHeader("Expires", 0) ;  
        //指定生成的相应图片  
        response.setContentType("image/jpeg") ; 
        
    	IdentifyingCode idCode = new IdentifyingCode();  
        BufferedImage image =new BufferedImage(idCode.getWidth() , idCode.getHeight() , BufferedImage.TYPE_INT_BGR) ;  
        Graphics2D g = image.createGraphics() ;  
        //定义字体样式  
        Font myFont = new Font("黑体" , Font.BOLD , 16) ;  
        //设置字体  
        g.setFont(myFont) ;  
          
        g.setColor(idCode.getRandomColor(200 , 250)) ;  
        //绘制背景  
        g.fillRect(0, 0, idCode.getWidth() , idCode.getHeight()) ;  
          
        g.setColor(idCode.getRandomColor(180, 200)) ;  
        idCode.drawRandomLines(g, 160) ;  
        idCode.drawRandomString(4, g) ;  
        g.dispose() ;  
        ImageIO.write(image, "JPEG", response.getOutputStream()) ;

    }
    
    @RequestMapping(value="/journaling", method=RequestMethod.POST)
    public @ResponseBody String journaling(
            @RequestParam("file") MultipartFile file,@RequestParam("journaling") String text){
    	String name = null;
    	String orginName = null;
    	String type = null;
    	
    	log.error("--journaling---"+text);
    	
    	Diary diary = new Diary();
    	
    	diary.setContext(text);
    	diary.setUserId(123456);
    	diary.setTitle("");
    	BaseValueUtil.setCreateBaseEntityValue(diary);
    	diaryService.addDiary(diary);

        if (!file.isEmpty()) {
            try {
            	orginName = file.getOriginalFilename();
            	type = file.getContentType();
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(UPLOAD_PATH+orginName)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded  "+orginName+"--type-"+type;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }


    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(
            @RequestParam("file") MultipartFile file){
    	String name = null;
    	String orginName = null;
    	String type = null;
        if (!file.isEmpty()) {
            try {
            	orginName = file.getOriginalFilename();
            	type = file.getContentType();
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(UPLOAD_PATH+orginName)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded  "+orginName+"--type-"+type;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

}