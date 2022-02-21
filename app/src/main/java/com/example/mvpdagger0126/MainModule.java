package com.example.mvpdagger0126;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpdagger0126.MainActScope;
import com.example.mvpdagger0126.MainContract;
import com.example.mvpdagger0126.MainPresenter;

import java.util.Calendar;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainModule {
    @Provides
    @MainActScope
    public static AppCompatActivity provideAppCompatActivity(){
        return new AppCompatActivity();
    }

    @Provides
    @MainActScope
    public static Context provideContext(AppCompatActivity appCompatActivity){
        return appCompatActivity;
    }

    @Provides
    @MainActScope
    public static MainContract.Presenter<MainContract.View> getPresenter(MainPresenter<MainContract.View> presenter){
        return presenter;
    }
}
