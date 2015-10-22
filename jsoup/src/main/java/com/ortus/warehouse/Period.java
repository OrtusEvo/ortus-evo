package com.ortus.warehouse;

/**
 * Created by Code_Beast on 9/21/2015.
 */
public class Period {
    public static String  StartTime;
    public static String  EndTime;
    public static String PeriodTime;
    public static int TotalHours;
    public static int TotalMinutes;


    public Period(){
        this("00:00-00:00");
    }
    public Period(String period){
        PeriodTime=period;
        String[] periodArray=period.split("-");
        if(periodArray.length>0 && periodArray.length==2){

        }

    }
    public Period(String start,String end){
        StartTime=start;
        EndTime=end;
        PeriodTime=start+"-"+end;
    }
    public void setPeriod(String period){
        PeriodTime=period;

    }
    public void setPeriod(String start,String end){
        StartTime=start;
        EndTime=end;
        PeriodTime=start+"-"+end;

    }
    public void CalcTime(String start,String end){

    }

    /**
     * getStartTime returns starting time of the class
     * for instance 10:30 to 12:00 will return 10:30
     * @return
     *
     */

    public static String  getStartTime() {
        return StartTime;
    }

    /**
     * getEndTime returns the ending time of the class
     * for instance 10:30 to 12:00 will return 12:00
     * @return
     */
    public static String  getEndTime() {
        return EndTime;
    }

    public static String getPeriodTime() {
        return PeriodTime;
    }

    public static int getTotalHours() {
        return TotalHours;
    }

    public static int getTotalMinutes() {
        return TotalMinutes;
    }
}
