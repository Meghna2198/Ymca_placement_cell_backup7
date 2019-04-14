package com.ymca.student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class testClass extends Activity {
    Button signup_button,login_aint_register,login_button1,reqirements_button1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        signup_button = (Button) findViewById(R.id.signup_button);
        login_aint_register = (Button) findViewById(R.id.login_and_not_registered);
        login_button1 = (Button) findViewById(R.id.login_button);
        reqirements_button1 = (Button) findViewById(R.id.company_requirements);
        signup_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                func1();
            }
        });
        login_aint_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                func2();
            }
        });
        login_button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                login_page();
            }
        });
        reqirements_button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                requirements_page();
            }
        });
    }
    public void func1()
    {
        Intent i = new Intent(this,newUser.class);
        startActivity(i);
    }
    public void func2()
    {

        Intent i2=new Intent(this,activity_main1_class.class);
        startActivity(i2);
    }
    public void login_page()
    {
        Intent i3=new Intent(this,MainActivity1.class);
        startActivity(i3);
    }
    public void requirements_page()
    {
        Intent i4=new Intent(this,requirementsClass.class);
        startActivity(i4);
    }
}
