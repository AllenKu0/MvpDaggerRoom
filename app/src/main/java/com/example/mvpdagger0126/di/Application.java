package com.example.mvpdagger0126.di;

import android.content.Context;


public class Application extends android.app.Application {
    private ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().build();
        applicationComponent.inject(this);
    }
    public static Application get(Context context){
        return (Application)context.getApplicationContext();
    }
    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}