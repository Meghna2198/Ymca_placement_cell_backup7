package com.ymca.student;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
import java.util.ArrayList;

public class MainActivity1 extends Activity implements  IHttpTextReaderCallback {
    EditText editName, editPassword;
    TextView result;
    Button buttonSubmit, buttonReset;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        editName  = (EditText) findViewById(R.id.usernameedit);
        editPassword = (EditText) findViewById(R.id.editText3);
        result= (TextView)  findViewById(R.id.textView5);
        buttonSubmit = (Button) findViewById(R.id.submitbutton);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();
                result.setText("Name:\t" + name + "\nPassword:\t" + password );
                fun();
            }
        });
        ShowAlertDialogWithListview();

        Toast.makeText(this,"here",Toast.LENGTH_SHORT).show();

    }

    public void ShowAlertDialogWithListview() {
        List<String> mChoice = new ArrayList<String>();
        mChoice.add("Company ");
        mChoice.add("Student");
        //Create sequence of items
        final CharSequence[] Animals = mChoice.toArray(new String[mChoice.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Register As");
        dialogBuilder.setItems(Animals, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = Animals[item].toString();  //Selected item in listview
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();;
            }
        });
        //Create alert dialog object via builder
        AlertDialog alertDialogObject = dialogBuilder.create();
        //Show the dialog
        alertDialogObject.show();
    }

     public void fun()
     {
         Intent i = new Intent(this,newUser.class);
         startActivity(i);
     }

    @Override
    public void dataReceived(String paramString) {

        Toast.makeText(this,paramString,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedToReceiveData() {

    }
}

