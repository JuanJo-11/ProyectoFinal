package com.example.proyectofinal.ui;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BackgroundIntentService extends IntentService {

    public BackgroundIntentService() {
        super(BackgroundIntentService.class.getName());
    }



    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(this.getClass().getSimpleName(),"onHandleIntent");
        Handler mHandler = new Handler(getMainLooper());
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"Alarma", Toast.LENGTH_SHORT).show();

            }
        });

    }
}

