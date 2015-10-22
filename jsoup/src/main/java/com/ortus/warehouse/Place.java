package com.ortus.warehouse;

//import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Code_Beast on 9/21/2015.
 */
public class Place {

    public static String Place_Name;
    public static String Room_No;
   // public static LatLng Coordinates;

    public Place() {
        this("Not_Defined", "Not_Defined");
    }

    public Place(String place, String room_No) {
        Place_Name = place;
        Room_No = room_No;

    }

    public void setPlace_Name(String place) {
        Place_Name = place;
    }

    public String getPlace_Name() {
        return Place_Name;
    }

    public String getRoom_No() {
        return Room_No;
    }

  /*  public LatLng getGeolocation() {
        return Coordinates;
    }*/

    public void convertPlaceToGeolocation(String place) {
        //TODO implement geolocation library
    }
}
