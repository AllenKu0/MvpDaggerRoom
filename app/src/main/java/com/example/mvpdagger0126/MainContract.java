package com.example.mvpdagger0126;

import com.example.mvpdagger0126.model.Users;
import com.example.mvpdagger0126.ui.base.BaseAttachImpl;
import com.example.mvpdagger0126.ui.base.BaseContract;

import java.util.List;

public interface MainContract {
    interface View extends BaseContract {
        void setData (List<Users> users);
    }
    interface Presenter <V extends View> extends BaseAttachImpl<V> {
        void getUsersList();
    }
}
