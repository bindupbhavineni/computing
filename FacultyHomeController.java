package com.wku.security.computing;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Bindu
 */

@Controller
public class FacultyHomeController {
    
	 ApplicationContext context =
	            new ClassPathXmlApplicationContext("/spring-context.xml");
    SMDao srmdao = (SMDao) context.getBean("srmDAO");
    
   
    AddCourseModel addCourseModel = (AddCourseModel) context.getBean("addCourseModel");
    //ApplicationModel applicationModel = (ApplicationModel) context.getBean("applicationModel");
    ApplicationModel applicationModel = new ApplicationModel();
    @RequestMapping(value = "/addCourse.do",method = RequestMethod.POST)
    public ModelAndView addCourse(@ModelAttribute("addCourseDetails")AddCourseModel addCourseModel,
            ApplicationModel applicationModel,
    ModelMap model,BindingResult bindingResult, 
            HttpServletRequest request, HttpServletResponse response) {
        
         
     boolean status =   srmdao.registerCourse(applicationModel.getAddCourseModel());
        if(status){
            String message = "Course added to User successfully";
            applicationModel.setMessage(message);
            return new ModelAndView("addCourse", "addCourseDetails", applicationModel);
        } else{
            String message = "Course not added to User! Try again";
            applicationModel.setMessage(message);
            return new ModelAndView("addCourse", "addCourseDetails", applicationModel);
        }        
    }
    
    

        
    
  
    
}
