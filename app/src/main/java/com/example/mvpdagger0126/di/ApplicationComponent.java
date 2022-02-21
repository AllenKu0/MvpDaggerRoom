package com.example.mvpdagger0126.di;

import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.disposables.CompositeDisposable;

@Singleton
@Component(modules = {ApplicationModule.class,
        APIModule.class,})
public interface ApplicationComponent {

    void inject(Application application);

    APIService getAPIService();

    CompositeDisposable getCompositeDisposable();


}
