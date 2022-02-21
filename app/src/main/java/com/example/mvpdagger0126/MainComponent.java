package com.example.mvpdagger0126;

import com.example.mvpdagger0126.di.ApplicationComponent;

import dagger.Component;

@MainActScope
@Component(modules = MainModule.class,
        dependencies = ApplicationComponent.class)
public interface MainComponent {

    void inject(MainActivity activity);
}
