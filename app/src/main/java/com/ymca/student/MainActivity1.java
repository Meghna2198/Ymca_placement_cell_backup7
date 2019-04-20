package com.ymca.student;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
import java.util.ArrayList;

public class MainActivity1 extends Activity  {
    static MainActivity1 activity=null;

    EditText editName, editPassword;
    TextView result;
    Button buttonSubmit, buttonLogin;
    ProgressDialog mProgressBar=null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        activity=this;
        editName  = (EditText) findViewById(R.id.usernameedit);
        editPassword = (EditText) findViewById(R.id.editText3);
        result= (TextView)  findViewById(R.id.textView5);
        buttonSubmit = (Button) findViewById(R.id.submitbutton);
        buttonLogin=(Button)findViewById(R.id.loginbutton);
        mProgressBar = new ProgressDialog(this);
        mProgressBar.setMessage("Validating user....");
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressBar.setIndeterminate(true);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = editName.getText().toString();
                String password = editPassword.getText().toString();
                result.setText("Name:\t" + name + "\nPassword:\t" + password );
             //   Toast.makeText(MainActivity1.this,"here1111"+editName.getText().toString(),Toast.LENGTH_SHORT).show();
                fun();
            }
        });
      //  ShowAlertDialogWithListview();




        buttonLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                mProgressBar.show();
                Log.w("url" , "http://mobimonsterit.com/ymca/register_login.php?username=" + editName.getText().toString() + "&password=" + editPassword.getText().toString() + "&UserType=s");

                HttpConnectionHandler.GetTextFileFromServerSimpleURL("http://mobimonsterit.com/ymca/register_login.php?username=" + editName.getText().toString() + "&password=" + editPassword.getText().toString() + "&UserType=s", new IHttpTextReaderCallback() {

                    @Override
                    public void dataReceived(final String paramString) {

                        Log.w("here11","here data received " + paramString);
                //        Toast.makeText(MainActivity1.this,"FDSFSDF" + paramString,Toast.LENGTH_SHORT).show();
                    //    do_register();
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity1.this,"in" + paramString,Toast.LENGTH_SHORT).show();
                                mProgressBar.dismiss();
                                if(paramString=="2")
                                {
                                    Intent i2=new Intent(MainActivity1.this,activity_main1_class.class);
                                    startActivity(i2);
                                }
                              //  mProgressBar.dismiss();
                            }
                        });
                    }

                    @Override
                    public void failedToReceiveData() {
                        Toast.makeText(MainActivity1.this,"Failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
       // showSnackBar();
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
     public void do_register()
     {
         Intent i2=new Intent(this,activity_main1_class.class);
         startActivity(i2);
     }
     public void showSnackBar()
     {
//         CoordinatorLayout mCoordinatorLayout= (CoordinatorLayout)findViewById(R.id.coordinatorLayout);
//         Snackbar snackbar = Snackbar
//                 .make(mCoordinatorLayout , "No internet connection!", Snackbar.LENGTH_LONG)
//                 .setAction("RETRY", new View.OnClickListener() {
//                     @Override
//                     public void onClick(View view) {
//                     }
//                 });
//
//// Changing message text color
//         snackbar.setActionTextColor(Color.RED);
//
//// Changing action button text color
//         View sbView = snackbar.getView();
//     //    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
//       //  textView.setTextColor(Color.YELLOW);
//         snackbar.show();
     }
}


