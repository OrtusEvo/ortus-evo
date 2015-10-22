package com.survivingwithandroid.jsoup;

/**
 * Created by Code_Beast on 9/11/2015.
 */
public class Logger {
   static Logger logger;

    private Logger(){

    }
    public static Logger getInstance(){     //FIXME  Design pattern Singlton add multi-thread sync Block
        if(logger!=null){
            logger=new Logger();
        }
        return logger;
    }

    public void log(String Log){

    }
    public void w(String warning){

    }
    public void d(String debug){

    }
    public void e(String error){

    }
}
