package com.example.mvpdagger0126;

import android.util.Log;

import com.example.mvpdagger0126.di.APIService;
import com.example.mvpdagger0126.model.Users;
import com.example.mvpdagger0126.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter<V extends MainContract.View> extends BasePresenter<V> implements MainContract.Presenter<V>{

    @Inject
    public MainPresenter(APIService apiService, CompositeDisposable compositeDisposable) {
        super(apiService, compositeDisposable);
    }


    @Override
    public void getUsersList() {
        getView().showProgressDialog("Loading...");
        getCompositeDisposable().add(getApiService()
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Users>>() {
                    @Override
                    public void onNext(List<Users> value) {
                        //拿到 V extends MainContract.View 的 V
                        Log.e( "onNext: ", "onNext is calling");
                        getView().setData(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e( "onError: ",e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e( "onComplete: ", "onComplete is calling");
                        getView().dismissProgressDialog();
                    }
                })
        );
    }
}
