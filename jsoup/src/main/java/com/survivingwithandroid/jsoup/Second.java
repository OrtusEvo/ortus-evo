package com.survivingwithandroid.jsoup;

/**
 * Created by Code_Beast on 9/7/2015.
 */
public class Second {
    public String name;
    public String country;
    public Second(String name,String country){
        setName(name);
        setCountry(country);
    }
    public void setName(String data){
        this.name=data;

    }

    public void setCountry(String data){
        this.country=data;

    }

    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
}
