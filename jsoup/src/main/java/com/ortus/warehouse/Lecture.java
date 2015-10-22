package com.ortus.warehouse;

/**
 * Created by Code_Beast on 9/21/2015.
 */
public class Lecture {
    public static Period period;
    public static Subject subject;
    public static Teacher teacher;
    public static Place place;

    public Lecture(Period timePeriod,Subject subjectName,Teacher teacherName,Place placeName){
        period=timePeriod;
        subject=subjectName;
        teacher=teacherName;
        place=placeName;

    }

    public static Period getPeriod() {
        return period;
    }

    public static Teacher getTeacher() {
        return teacher;
    }

    public static Subject getSubject() {
        return subject;
    }

    public static Place getPlace() {
        return place;
    }
}
