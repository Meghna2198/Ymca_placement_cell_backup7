package com.ymca.student;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static com.ymca.student.newUser.userName;

public class requirementsClass extends Activity {
    static requirementsClass requirement_activity = null;
    ProgressDialog mProgressBar = null;
    private Spinner spinner_OS1;
    EditText cgpa, salary;
    Button submit_requirements;
    Button exit_requirements;
    String spinner_text, cgpa_text, salary_text;

    protected void onCreate(Bundle savedInstanceState) {
        requirement_activity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.requirements);
        cgpa = findViewById(R.id.cgpa_required);
        salary = findViewById(R.id.salary_given);
        exit_requirements = (Button) findViewById(R.id.exit_requirementsbutton);
        submit_requirements = findViewById(R.id.requirements);
        mProgressBar = new ProgressDialog(this);
        mProgressBar.setMessage("Validating user....");
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressBar.setIndeterminate(true);
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
        spinner_OS1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //	This method is called when we select any item from our Spinner
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(getApplicationContext(), spinner_OS1.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }

            //	This method is called when no item is selected from our Spinner
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_text = spinner_OS1.getSelectedItem().toString();
        cgpa_text = cgpa.getText().toString();
        salary_text = salary.getText().toString();
        submit_requirements.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                HandleSumbit();

            }


        });
    }

    private void HandleSumbit()
    {

        mProgressBar.show();
        if (TextUtils.isEmpty(cgpa.getText().toString())) {
            // etUserName.setError("Your message");
            Toast.makeText(requirementsClass.this, "You haven't enter the minimum cgpa", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(salary.getText().toString())) {
            // etUserName.setError("Your message");
            Toast.makeText(requirementsClass.this, "You haven't enter the salary to be paid", Toast.LENGTH_SHORT).show();
            return;
        }
        HttpConnectionHandler.GetTextFileFromServerSimpleURL("http://mobimonsterit.com/ymca/postjob.php?username=" + userName + "&branch=" + spinner_OS1.getSelectedItem().toString() + "&cgpa=" + cgpa.getText().toString() + "&package=" + salary.getText().toString(), new IHttpTextReaderCallback() {


            public void dataReceived(final String paramString) {

                Log.w("here", "here data received " + paramString);
                requirement_activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(requirementsClass.this, "Response " + paramString, Toast.LENGTH_SHORT).show();
                        if(paramString.equals("exist"))
                            Toast.makeText(requirementsClass.this, "Job has been posted already!", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(requirementsClass.this, "Job posted successfully", Toast.LENGTH_SHORT).show();
                        mProgressBar.dismiss();
                    }
                });
            }

            @Override
            public void failedToReceiveData() {
                Toast.makeText(requirementsClass.this, "Failed", Toast.LENGTH_SHORT).show();
            }

        });

        exit_requirements.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });

    }

}