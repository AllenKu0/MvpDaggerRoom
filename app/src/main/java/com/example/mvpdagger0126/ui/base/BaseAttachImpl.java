package com.example.mvpdagger0126.ui.base;

public interface BaseAttachImpl <V extends BaseContract>{
    void onAttached(V view);
    void onDetached();
}
