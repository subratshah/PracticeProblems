package com.example.dagger;

public class Wheels {

    private Tires tire;
    private Rims rims;

    public Wheels(Rims rims, Tires tire) {
        this.tire = tire;
        this.rims = rims;
    }
}
