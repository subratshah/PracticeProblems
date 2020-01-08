package com.example.dagger;

import dagger.Component;

@Component(modules = WheelsModule.class)
public interface CarComponent {
    void inject(MainActivity mainActivity);
}
