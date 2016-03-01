package com.wit.ie.doolysv2.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.wit.ie.doolysv2.R;

public class LoginActivity extends AppCompatActivity {


    protected EditText musername;
    protected EditText mpassword;
    protected Button mloginbutton;
    protected Button btnLinkToRegisterScreen;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initializing text and buttons
        musername = (EditText)findViewById(R.id.Username);
        mpassword = (EditText)findViewById(R.id.password);
        mloginbutton = (Button)findViewById(R.id.btnLogin);
        btnLinkToRegisterScreen = (Button)findViewById(R.id.btnLinkToRegisterScreen);


        //listen to login button
        mloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get user details and convert toString
                String username = musername.getText().toString().trim();
                String password = mpassword.getText().toString().trim();


                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {

                        if (e == null) {

                            //User logged in successfully
                            Toast.makeText(LoginActivity.this, "Welcome Back!", Toast.LENGTH_LONG).show();

                            //Bring to home page
                            Intent main = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(main);
                            finish();

                        } else {

                            //Login up failure, create error alert dialog box
                            //http://stackoverflow.com/questions/2115758/how-to-display-alert-dialog-in-android
                            //Toast.makeText(LoginActivity.this, "Login In Failure", Toast.LENGTH_LONG).show();
                            AlertDialog.Builder errorMessage = new AlertDialog.Builder(LoginActivity.this);
                            errorMessage.setMessage(e.getMessage());
                            errorMessage.setTitle("Login Error");
                            errorMessage.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.dismiss();
                                }
                            });
                            AlertDialog dialog = errorMessage.create();
                            dialog.show();


                        }

                    }
                });

            }
        });


        btnLinkToRegisterScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Bring user to sign up
                Intent test = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(test);
            }
        });





    }
    //disable back button
    @Override
    public void onBackPressed() {
    }

}
