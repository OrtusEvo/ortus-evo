package com.ortus.warehouse;

/**
 * Created by Code_Beast on 9/21/2015.
 */
public class Teacher {
    public  static String TeacherName;

    public Teacher(){
        this("Not Defined");
    }
    public Teacher(String teacherName){
        TeacherName=teacherName;
    }
    public void setTeacherName(String teacherName){
        TeacherName=teacherName;
    }
    public String getTeacherName(){
        return  TeacherName;
    }
}
