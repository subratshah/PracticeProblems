package com.example.dagger;

import android.util.Log;

import javax.inject.Inject;

class Engine {

    private static final String TAG = "Car";

    @Inject
    Engine() {
        Log.d(TAG, "Engine Running");
    }
}
