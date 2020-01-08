package com.example.dagger;

import android.util.Log;

import javax.inject.Inject;

class Car {
    private static final String TAG = "Car";

    private Wheels wheels;
    private Engine engine;

    @Inject
    Car(Wheels wheels, Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    void drive() {
        Log.d(TAG, "Car Driving");
    }
}
