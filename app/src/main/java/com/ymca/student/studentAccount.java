package com.ymca.student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class studentAccount extends Activity {
  Button svacancies,scompany,sdetails;

    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_account);
        svacancies=(Button) findViewById(R.id.button_view_vacancies);
        scompany=(Button) findViewById(R.id.button_view_company);
        sdetails=(Button) findViewById(R.id.button_edit_details);
        sdetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                edit_details();
            }
        });
    }
    public void edit_details()
    {
        Intent i=new Intent(this,studentInfo.class);
        startActivity(i);
    }

}
