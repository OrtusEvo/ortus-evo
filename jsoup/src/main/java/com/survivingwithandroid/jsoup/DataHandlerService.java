package com.survivingwithandroid.jsoup;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class DataHandlerService extends Service {

    Logger logger;
    DataReciever dr;
    public DataHandlerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // TODO: Add inter com link <MainActivity>
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate()
    {
        logger=Logger.getInstance();

    }

    public void startReciever(){
        IntentFilter broadcast=new IntentFilter();
        broadcast.addAction(Constants.ConToDataRecvr);
        dr=new DataReciever();
        logger.d("<dr : DataReciever> BroadcastReceiver initialised");
        registerReceiver(dr, broadcast);
        logger.d("<dr : DataReciever> BroadcastReciever registered with key "+ Constants.ConToDataRecvr);

    }
    public void stopReciever(){
        if(dr!=null){
            unregisterReceiver(dr);
        }else
        {
            //TODO put warning  log
            logger.log("");
            logger.e("<dr : DtataReciever> BroadcastReceiver is null or not initialised");

        }

    }




}
