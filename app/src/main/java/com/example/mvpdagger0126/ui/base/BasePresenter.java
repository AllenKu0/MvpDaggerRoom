package com.example.mvpdagger0126.ui.base;

import com.example.mvpdagger0126.di.APIService;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<V extends BaseContract> implements BaseAttachImpl<V>{

    private V view;

    private APIService apiService;

    private CompositeDisposable compositeDisposable;
    @Inject
    public BasePresenter(APIService apiService,CompositeDisposable compositeDisposable){
        this.apiService = apiService;
        this.compositeDisposable = compositeDisposable;
    }

    public V getView() {
        return view;
    }

    @Override
    public void onAttached(V view) {
        this.view = view;
    }

    @Override
    public void onDetached() {
        this.view = null;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
    public APIService getApiService(){
        return apiService;
    }
}
