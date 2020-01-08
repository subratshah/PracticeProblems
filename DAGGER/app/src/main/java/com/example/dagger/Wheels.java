package com.example.dagger;

class Wheels {

    private Tires tire;
    private Rims rims;

    Wheels(Rims rims, Tires tire) {
        this.tire = tire;
        this.rims = rims;
    }
}
