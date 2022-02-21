package com.example.mvpdagger0126.di;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class APIModule {

    @Provides
    @Singleton
    static APIService provideService(@Named("UserApi")Retrofit retrofit){
        return retrofit.create(APIService.class);
    }

    @Provides
    @Singleton
    @Named("UserApi")
    static Retrofit provideRetrofit(@Named("UserApiUrl") String url,
                             @Named("UserApiClient") OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    @Provides
    @Singleton
    @Named("UserApiUrl")
    static String provideUserApiUrl(){
        return "https://jsonplaceholder.typicode.com";
    }

    @Provides
    @Singleton
    @Named("UserApiClient")
    static OkHttpClient provideUserOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    static HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
