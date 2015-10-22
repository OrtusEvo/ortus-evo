package com.survivingwithandroid.jsoup;

import java.util.LinkedList;

/**
 * Created by Code_Beast on 9/7/2015.
 */
public class LogicAdapter {

    LinkedList<Second> second;

    public LogicAdapter(){
        second=new LinkedList<Second>();

        this.second.add(new Second("Shivam", "India"));
       this.second.add(new Second("Sancho","Uzbekistan"));
        this.second.add(new Second("Markus","Nigeria"));
        this.second.add(new Second("Hyder Ali","Uzbekistan"));




    }
    public LinkedList<Second> getInfo(){
        return this.second;
    }
}
