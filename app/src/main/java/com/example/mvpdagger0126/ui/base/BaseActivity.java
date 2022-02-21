package com.example.mvpdagger0126.ui.base;

import android.app.ProgressDialog;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity implements BaseContract {
    ProgressDialog progressDialog;
    @Override
    public void init() {


    }

    @Override
    public void showProgressDialog(String s) {
        dismissProgressDialog();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Waiting");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.cancel();
        }
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
}
