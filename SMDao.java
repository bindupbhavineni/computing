package com.wku.security.computing;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class SMDao {

	private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

  
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);

    }
	
	public boolean registerCourse(AddCourseModel addCourseModel) {
        boolean status = false;

        String SQL = "INSERT INTO course_registration(course_id,univ_user_id) VALUES(?,?)";
        int course_id = getCourseID(addCourseModel.getCourseName());
        try {
            jdbcTemplate.update(SQL, new Object[]{course_id, addCourseModel.getUnivid()});
            status = true;

        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
	
	public int getCourseID(String courseName) {

        String SQL = "SELECT course_id FROM course WHERE course_name=?";
        int course_id = 0;
        try {
            course_id = Integer.parseInt(jdbcTemplate.queryForObject(SQL,
                    new Object[]{courseName}, String.class));
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }
        return course_id;
    }

	
}
