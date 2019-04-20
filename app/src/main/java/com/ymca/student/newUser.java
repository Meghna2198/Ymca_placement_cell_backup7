package com.ymca.student;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class newUser extends Activity {
    EditText editName1,editPassword1,editConfirmPassword1;
    TextView result2;
    Button buttonSubmit1;
    Button exitButton;
    String spinner_OS_text;
    private Spinner spinner_OS;
    static String userName;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newuser);
        spinner_OS = (Spinner) findViewById(R.id.spinner1);

        ArrayList<String> OS_list = new ArrayList<String>();
        OS_list.add("Company");
        OS_list.add("Student");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, OS_list);
        spinner_OS.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_OS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            //	This method is called when we select any item from our Spinner
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                Toast.makeText(getApplicationContext(), spinner_OS.getSelectedItem().toString() , Toast.LENGTH_LONG).show() ;
            }
            //	This method is called when no item is selected from our Spinner
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
        editName1  = (EditText) findViewById(R.id.EnterUsername1);
        editPassword1 = (EditText)  findViewById(R.id.editText4);
        editConfirmPassword1 = (EditText) findViewById(R.id.editText6);
        result2 =(TextView) findViewById(R.id.textView6);
        buttonSubmit1 = (Button) findViewById(R.id.submitbutton);
        exitButton=(Button) findViewById(R.id.exit_button);
        buttonSubmit1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = editName1.getText().toString();
                String password = editPassword1.getText().toString();
                String confirm_password= editConfirmPassword1.getText().toString();
                spinner_OS_text=spinner_OS.getSelectedItem().toString();
                if (TextUtils.isEmpty(name)) {
                    // etUserName.setError("Your message");
                    Toast.makeText(newUser.this, "You haven't enter the username", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    userName=editName1.getText().toString();
                }
                if (TextUtils.isEmpty(password)) {
                    // etUserName.setError("Your message");
                    Toast.makeText(newUser.this, "You haven't enter the password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirm_password)) {
                    // etUserName.setError("Your message");
                    Toast.makeText(newUser.this, "Please confirm password", Toast.LENGTH_SHORT).show();
                    return;
                }
                result2.setText("Name:\t" + name + "\nPassword:\t" + password+"\nCPassword:\t"+confirm_password);
                if(password.equals(confirm_password)) {
                    Toast.makeText(newUser.this, "Password matched", Toast.LENGTH_SHORT).show();
                    if(spinner_OS_text.equals("Company"))
                    {
                        Intent i=new Intent(newUser.this,activity_main1_class.class);
                        startActivity(i);
                    }
                    else
                    {
                        Intent i=new Intent(newUser.this,studentAccount.class);
                        startActivity(i);
                    }
                }
                else
                    Toast.makeText(newUser.this,"Password do not match",Toast.LENGTH_SHORT).show();

            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });
    }

}
