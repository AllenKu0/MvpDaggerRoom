package com.example.mvpdagger0126.di;

import com.example.mvpdagger0126.model.Users;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {
    @GET("/users")
    Observable<List<Users>> getUsers();
}
