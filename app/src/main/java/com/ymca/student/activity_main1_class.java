package com.ymca.student;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ymca.student.newUser.userName;

public class activity_main1_class extends Activity {
    static activity_main1_class activity=null;
    ProgressDialog mProgressBar=null;
    Button submitButton,exitButton;
    EditText name1,email1,phone1,address1,contactName1;
   // final TextView textView = (TextView)findViewById(R.id.text);
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
        String email_check = email1.getText().toString();
        if(isValidEmail(email_check)){
            Toast.makeText(v.getContext(), "Email is valid", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(v.getContext(), "Email is invalid", Toast.LENGTH_LONG).show();
        }
    }
    private boolean validatePhone(View v)
    {
        String MobilePattern = "[0-9]{10}";
        if(phone1.getText().toString().matches(MobilePattern)) {
            return true;
        }
        else
            return false;

    }
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
        exitButton=findViewById(R.id.register_exit_);
        mProgressBar = new ProgressDialog(this);
        mProgressBar.setMessage("Validating user....");
        mProgressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressBar.setIndeterminate(true);


        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mProgressBar.show();
                if(TextUtils.isEmpty(name1.getText().toString())) {
                   // etUserName.setError("Your message");
                    Toast.makeText(activity_main1_class.this,"You haven't enter the user name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(email1.getText().toString())) {
                    // etUserName.setError("Your message");
                    Toast.makeText(activity_main1_class.this,"You haven't enter the email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(phone1.getText().toString())) {
                    // etUserName.setError("Your message");
                    Toast.makeText(activity_main1_class.this,"You haven't enter the phone number",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(address1.getText().toString())) {
                    // etUserName.setError("Your message");
                    Toast.makeText(activity_main1_class.this,"You haven't enter the address",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(contactName1.getText().toString())) {
                    // etUserName.setError("Your message");
                    Toast.makeText(activity_main1_class.this,"You haven't enter the contact name",Toast.LENGTH_SHORT).show();
                    return;
                }

                validateEmail(v);
                if(validatePhone(v))
                    Toast.makeText(getApplicationContext(), "phone number is valid", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "phone number is invalid", Toast.LENGTH_SHORT).show();

                Toast.makeText(activity_main1_class.this,"hello",Toast.LENGTH_SHORT).show();
                HttpConnectionHandler.GetTextFileFromServerSimpleURL("http://mobimonsterit.com/ymca/register_user.php?username="+userName+"&name="+name1.getText().toString()+"&email="+email1.getText().toString()+"&phone="+phone1.getText().toString()+"&contactp="+contactName1.getText().toString()+"&paddress="+address1.getText().toString()+"&UserType=s", new IHttpTextReaderCallback() {


                 //   HttpConnectionHandler.GetTextFileFromServerSimpleURL("http://mobimonsterit.com/ymca/register_login.php?username=name1.getText().toString()&password=phone1.getText().toString()&UserType=s", new IHttpTextReaderCallback() {

                    @Override
                    public void dataReceived(final String paramString) {

                        Log.w("here","here data received " + paramString);
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(activity_main1_class.this,"FDSFSDF" + paramString,Toast.LENGTH_SHORT).show();
                            //    Intent i=new Intent(activity_main1_class.this,grid_activity_main.class);
                             //   startActivity(i);
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
