package com.example.mvpdagger0126;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvpdagger0126.di.APIService;
import com.example.mvpdagger0126.di.Application;
import com.example.mvpdagger0126.model.Users;
import com.example.mvpdagger0126.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    APIService apiService;
    @Inject
    MainContract.Presenter<MainContract.View> presenter;

    private TextView textView;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainComponent component = DaggerMainComponent.builder()
                                  .applicationComponent(((Application) getApplication()).getApplicationComponent())
                                  .build();

        component.inject(this);

        btn = findViewById(R.id.button);
        textView = findViewById(R.id.tv);

        presenter.onAttached(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getUsersList();
            }
        });
    }

    @Override
    public void setData(List<Users> users) {
        textView.setText(users.get(0).getUsername());
    }
}