package com.example.mvpdagger0126.di;

import android.content.Context;

import com.example.mvpdagger0126.di.Application;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public abstract class ApplicationModule {
    @Provides
    public static Application provideApplication(){
        return new Application();
    }

    @Provides
    public static Context provideContext(Application application){
        return application.getApplicationContext();
    }

    @Provides
    public static CompositeDisposable provideCompositeDisposable(){
        return new CompositeDisposable();
    }
}
