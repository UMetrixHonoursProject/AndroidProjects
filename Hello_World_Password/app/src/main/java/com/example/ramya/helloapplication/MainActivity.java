package com.example.ramya.helloapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.app.Activity;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class MainActivity extends Activity {

    EditText editPassword;
    CheckBox showPassword;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPassword = (EditText) findViewById(R.id.etPassword);
        showPassword = (CheckBox) findViewById(R.id.cbShowPwd);

        showPassword.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (!isChecked) {
                    // show password
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }
}
