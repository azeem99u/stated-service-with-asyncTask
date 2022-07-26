package com.azeem99u.startedserviswithasynctask;

import static com.azeem99u.startedserviswithasynctask.MainActivity.AZEEM;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;


public class MyService extends Service {
    private static final String TAG = "azeem";
    int a = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: called");
    }

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: called");
        String song = intent.getStringExtra(AZEEM);
        a = startId;
        MyAsyncTask myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute(song);
        return Service.START_REDELIVER_INTENT;
    }



    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: called");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: called");
    }

    class MyAsyncTask extends AsyncTask<String,String,String>{

        @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(String... songs) {
            for (String song: songs) {
                SystemClock.sleep(5000);
                onProgressUpdate(song);
            }
            return "songs are downloaded";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            Log.d(TAG, "onProgressUpdate: "+values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d(TAG, "onPostExecute: Result "+s);
            stopSelfResult(a);
        }
    }






}