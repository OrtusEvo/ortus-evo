package com.ortus.warehouse;

import java.util.LinkedList;

/**
 * Created by Code_Beast on 9/22/2015.
 */
public class Schedule {
    static Schedule schedule;
    private static LinkedList<ClassOnDay> classPerDay;
    private static String monthName;
    private static int DaysInMonth;

    private Schedule(){
        classPerDay=new LinkedList<ClassOnDay>();
    }
    public static Schedule getInstance() {
        if (schedule != null) {

            schedule=new Schedule();
        }
        return  schedule;

    }
    public void addClassOnDay(LinkedList<ClassOnDay> classOnDays){
        classPerDay=classOnDays;
    }

    public LinkedList<ClassOnDay> getAllClassOnDay(){
        return  classPerDay;
    }

    public ClassOnDay getClassOnDay(int dayNo){
        if(dayNo>0 && dayNo<=DaysInMonth) {
            return classPerDay.get(dayNo - 1);
        }else{
            return  classPerDay.getFirst();
        }
    }

}
