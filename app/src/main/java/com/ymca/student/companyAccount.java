package com.ymca.student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class companyAccount extends Activity {
   Button cvacancies,capplicants,cdetails;

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_account);
         cvacancies=(Button) findViewById(R.id.button_post_vacancies);
         capplicants=(Button) findViewById(R.id.button_view_applicants);
         cdetails=(Button) findViewById(R.id.button_edit_details);
        cvacancies.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                on_vacancy();
            }
        });
        cdetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                on_details();
            }
        });
    }
    public void on_vacancy()
    {
        Intent i=new Intent(this,requirementsClass.class);
        startActivity(i);
    }
    public void on_details()
    {
        Intent i=new Intent(this,newUser.class);
        startActivity(i);
    }

}
