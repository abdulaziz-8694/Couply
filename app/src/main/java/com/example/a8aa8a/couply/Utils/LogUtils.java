package com.example.a8aa8a.couply.Utils;

import android.util.Log;

import com.example.a8aa8a.couply.BuildConfig;

public class LogUtils {
    public static void logDebug(String TAG, String message){
        if(BuildConfig.DEBUG){
            Log.d(TAG, message);
        }
    }

    public static void logError(String TAG, String message){
        if(BuildConfig.DEBUG){
            Log.e(TAG, message);
        }
    }

    public static void logWarning(String TAG, String message){
        if(BuildConfig.DEBUG){
            Log.w(TAG, message);
        }
    }

    public static void logVerbose(String TAG, String message){
        if(BuildConfig.DEBUG){
            Log.v(TAG, message);
        }
    }

}
