package com.ymca.student;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class studentInfo extends Activity {
    static studentInfo activity1=null;
    EditText sname,semail,sphone,saddress,sbranch,scgpa;
    Button Ssubmit,Sexit;
    ProgressDialog sProgressBar=null;

    public static boolean isValidEmail(String email)
    {
        String expression = "^[\\w\\.]+@([\\w]+\\.)+[A-Z]{2,7}$";
        CharSequence inputString = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.matches()) {
            return true;
        } else{
            return false;
        }
    }
    public  void validateEmail(View v){
        String email_check = semail.getText().toString();
        if(isValidEmail(email_check)){
            Toast.makeText(v.getContext(), "Email is valid", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(v.getContext(), "Email is invalid", Toast.LENGTH_LONG).show();
        }
    }
    private boolean validatePhone(View v)
    {
        String MobilePattern = "[0-9]{10}";
        if(sphone.getText().toString().matches(MobilePattern)) {
            return true;
        }
        else
            return false;

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_info);
        activity1=this;
        sname=findViewById(R.id.register_sname);
        semail=findViewById(R.id.register_semail);
        sphone=findViewById(R.id.register_sphone);
        saddress=findViewById(R.id.register_sphoneaddress);
        sbranch=findViewById(R.id.register_sbranch);
        scgpa=findViewById(R.id.register_scgpa);
        Ssubmit=findViewById(R.id.register_Submit);
        Sexit=findViewById(R.id.registerExit);
        sProgressBar = new ProgressDialog(this);
        sProgressBar.setMessage("Validating user...");
        sProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        sProgressBar.setIndeterminate(true);
        Toast.makeText(studentInfo.this,"checking",Toast.LENGTH_SHORT).show();


        Ssubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                  sProgressBar.show();
                if (TextUtils.isEmpty(sname.getText().toString())) {
                    // etUserName.setError("Your message");
                    Toast.makeText(studentInfo.this, "You haven't enter the user name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(semail.getText().toString())) {
                    // etUserName.setError("Your message");
                    Toast.makeText(studentInfo.this, "You haven't enter the email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(sphone.getText().toString())) {
                    // etUserName.setError("Your message");
                    Toast.makeText(studentInfo.this, "You haven't enter the phone number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(saddress.getText().toString())) {
                    // etUserName.setError("Your message");
                    Toast.makeText(studentInfo.this, "You haven't enter the address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(sbranch.getText().toString())) {
                    // etUserName.setError("Your message");
                    Toast.makeText(studentInfo.this, "You haven't enter the branch", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(scgpa.getText().toString())) {
                    // etUserName.setError("Your message");
                    Toast.makeText(studentInfo.this, "You haven't enter the cgpa", Toast.LENGTH_SHORT).show();
                    return;
                }

              //  validateEmail(v);
                if(validatePhone(v))
                    Toast.makeText(getApplicationContext(), "phone number is valid", Toast.LENGTH_SHORT).show();
                  else
                    Toast.makeText(getApplicationContext(), "phone number is invalid", Toast.LENGTH_SHORT).show();

                  sProgressBar.dismiss();
                Toast.makeText(studentInfo.this, "hello", Toast.LENGTH_SHORT).show();
                //  HttpConnectionHandler.GetTextFileFromServerSimpleURL("http://mobimonsterit.com/ymca/register_user.php?uname=me&name=name1.getText().toString()&email=email1.getText().toString()&phone=phone1.getText().toString()&contactp=contactName1.getText().toString()&paddress=address1.getText().toString()&UserType=s", new IHttpTextReaderCallback() {


                HttpConnectionHandler.GetTextFileFromServerSimpleURL("http://mobimonsterit.com/ymca/register_login.php?username=name1.getText().toString()&password=phone1.getText().toString()&UserType=s", new IHttpTextReaderCallback() {

                    @Override
                    public void dataReceived(final String paramString) {

                        Log.w("here","here data received " + paramString);
                        activity1.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(studentInfo.this,"FDSFSDF" + paramString,Toast.LENGTH_SHORT).show();
                                sProgressBar.dismiss();
                            }
                        });
                    }

                    @Override
                    public void failedToReceiveData() {
                        Toast.makeText(studentInfo.this,"Failed",Toast.LENGTH_SHORT).show();
                    }


            });
        }
        });
        Sexit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });
}
}
