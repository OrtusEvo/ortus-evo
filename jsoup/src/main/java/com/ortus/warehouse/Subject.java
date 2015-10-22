package com.ortus.warehouse;

/**
 * Created by Code_Beast on 9/21/2015.
 */
public class Subject {
    public static String SubjectName;

    public Subject(){
        this("Not Defined");
    }
    public Subject(String subjectname){
        SubjectName=subjectname;
    }
    public void setSubjectName(String subjectname){
        SubjectName=subjectname;
    }
    public String getSubjectName(){
        return SubjectName;
    }
}
