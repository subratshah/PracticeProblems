package com.example.dagger;
import android.util.Log;
import javax.inject.Inject;

class Car {
    private static final String TAG = "Car";

    private Wheels wheels;
    private Engine engine;

    @Inject
    public Car(Wheels wheels, Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    public void drive() {
        Log.d(TAG, "Car Driving");
    }
}
