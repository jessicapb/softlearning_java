package com.core.entity.courses.services;

import com.core.entity.courses.model.Courses;
import com.core.entity.exceptions.BuildException;

public class CoursesMapper {
    public static Courses coursesFromDTO(CoursesDTO codto) throws BuildException{
        return Courses.getInstanceCourses(
            codto.getCode(), 
            codto.getPrice(), 
            codto.getDescription(), 
            codto.getHours(), 
            codto.getDepartment()
        );
    }

    public static CoursesDTO dtoFromCourses(Courses co){
        return new CoursesDTO(
            co.getcode(), 
            co.getprice(),
            co.getdescription(),
            co.getHours(),
            co.getDepartment(),
            co.getPassword()
        );
    }
}
