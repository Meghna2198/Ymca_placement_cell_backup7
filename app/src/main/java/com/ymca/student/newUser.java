package com.ymca.student;

import android.app.Activity;
import android.os.Bundle;
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
    private Spinner spinner_OS;



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
        buttonSubmit1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = editName1.getText().toString();
                String password = editPassword1.getText().toString();
                String confirm_password= editConfirmPassword1.getText().toString();
                result2.setText("Name:\t" + name + "\nPassword:\t" + password+"\nCPassword:\t"+confirm_password);

            }
        });
    }

//    public void exit_screen()
//    {
//        Intent i = new Intent(this,MainActivity1.class);
//        startActivity(i);
//    }
}
