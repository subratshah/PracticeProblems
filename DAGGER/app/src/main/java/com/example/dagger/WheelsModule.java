package com.example.dagger;

import dagger.Module;
import dagger.Provides;

@Module
class WheelsModule {

    @Provides
    Rims provideRims() {
        return new Rims();
    }

    @Provides
    Tires provideTires() {
        Tires tire = new Tires();
        tire.inflate();
        return tire;
    }

    @Provides
    Wheels provideWheels(Rims rims, Tires tires) {
        return new Wheels(rims, tires);
    }
}
