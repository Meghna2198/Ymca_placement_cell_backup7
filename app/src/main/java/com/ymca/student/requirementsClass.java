package com.ymca.student;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class requirementsClass extends Activity {
    private Spinner spinner_OS1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.requirements);
        spinner_OS1 = (Spinner) findViewById(R.id.spinner2);
        ArrayList<String> OS_list1 = new ArrayList<String>();
        OS_list1.add("CE");
        OS_list1.add("IT");
        OS_list1.add("ECE");
        OS_list1.add("EL");
        OS_list1.add("EIC");
        OS_list1.add("MECH");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, OS_list1);
        spinner_OS1.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_OS1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            //	This method is called when we select any item from our Spinner
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                Toast.makeText(getApplicationContext(), spinner_OS1.getSelectedItem().toString() , Toast.LENGTH_LONG).show() ;
            }
            //	This method is called when no item is selected from our Spinner
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
    }
}
