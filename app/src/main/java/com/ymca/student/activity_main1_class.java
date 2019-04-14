package com.ymca.student;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_main1_class extends Activity {
    static activity_main1_class activity=null;
    ProgressDialog mProgressBar=null;
    Button submitButton;
    EditText name1,email1,phone1,address1,contactName1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        activity=this;
        name1 = findViewById(R.id.register_name);
        email1 = findViewById(R.id.register_email);
        phone1 = findViewById(R.id.register_phone);
        address1 = findViewById(R.id.register_postal_address);
        contactName1 = findViewById(R.id.register_contact_person);
        submitButton = findViewById(R.id.register_submit);
        mProgressBar = new ProgressDialog(this);

        mProgressBar.setMessage("Validating user....");
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressBar.setIndeterminate(true);
        //mProgressBar.show();
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mProgressBar.show();
                Toast.makeText(activity_main1_class.this,"hello",Toast.LENGTH_SHORT).show();
                HttpConnectionHandler.GetTextFileFromServerSimpleURL("http://mobimonsterit.com/ymca/register_user.php?uname=me&name=name1.getText().toString()&email=email1.getText().toString()&phone=phone1.getText().toString()&contactp=contactName1.getText().toString()&paddress=address1.getText().toString()&UserType=s", new IHttpTextReaderCallback() {
                    @Override
                    public void dataReceived(final String paramString) {

                        Log.w("here","here data received " + paramString);
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(activity_main1_class.this,"FDSFSDF1" + paramString,Toast.LENGTH_SHORT).show();
                                mProgressBar.dismiss();
                            }
                        });
                    }

                    @Override
                    public void failedToReceiveData() {
                        Toast.makeText(activity_main1_class.this,"Failed",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
