package com.ortus.warehouse;

import java.util.LinkedList;

/**
 * Created by Code_Beast on 9/22/2015.
 */
public class ClassOnDay {
    public static LinkedList<Lecture> totalClasses;
    public static int numberOfClasses;

    public ClassOnDay() {
        totalClasses = new LinkedList<Lecture>();

    }

    public void addLecture(Lecture lecture) {
        totalClasses.add(lecture);
        updateNoOfClasses();
    }

    public void addLecture(LinkedList<Lecture> lectureLists){
        totalClasses=lectureLists;
        updateNoOfClasses();

    }

    public void removeLecture(int index) {
        totalClasses.remove(index);
    }

    public void updateNoOfClasses(){
        numberOfClasses=totalClasses.size();
    }

    public LinkedList<Lecture> getClasses() {
        return totalClasses;
    }

    public int getNumberOfClasses(){
        return numberOfClasses;
    }


}
