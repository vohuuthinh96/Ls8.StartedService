package com.atoproduction.ls8startedservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by : Thinhvh on 11/27/2020
 * Phone      : 0962890153 - 0398477967
 * Facebook   : https://www.facebook.com/thinh.super22
 * Skype      : https://join.skype.com/invite/fvfRTDLcGPJN
 * Mail       : thinhvhph04204@gmail.com
 */
public class PlaySongService  extends Service {

    private MediaPlayer mediaPlayer;
    String TAG = "thinhvh";
    public PlaySongService() {
    }

    // Return the communication channel to the service.
    @Override
    public IBinder onBind(Intent intent){
        // This service is unbounded
        // So this method is never called.
        Log.d(TAG, "onBind: ");
        return null;
    }


    @Override
    public void onCreate(){
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        // Create MediaPlayer object, to play your song.
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ytiet);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        // Play song.
        Log.d(TAG, "onStartCommand: ");
        mediaPlayer.start();
        return START_STICKY;
    }

    // Destroy
    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        // Release the resources
        mediaPlayer.release();
        super.onDestroy();
    }
}
