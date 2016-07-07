package com.wku.security.computing;

/**
 * This model class is used mainly to send the data into a single object which
 * contains all the details that is needed to be displayed on the jsp pages.
 *
 *
 *
 */
public class ApplicationModel {

  
 
    private AddCourseModel addCourseModel;
    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AddCourseModel getAddCourseModel() {
        return addCourseModel;
    }

    public void setAddCourseModel(AddCourseModel addCourseModel) {
        this.addCourseModel = addCourseModel;
    }
    
    
    

    
    
    
}