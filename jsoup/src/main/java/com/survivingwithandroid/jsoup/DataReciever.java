package com.survivingwithandroid.jsoup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class DataReciever extends BroadcastReceiver {
    public DataReciever() {
    }

    public void sendData(Context context,String data,String link_Key){ //Sending broadcast to main activity with some meta data
        IntentFilter broadcast=new IntentFilter();
        broadcast.addAction(link_Key);
        Bundle dataContainer=new Bundle();
        dataContainer.putCharSequence("DATA",data);

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
