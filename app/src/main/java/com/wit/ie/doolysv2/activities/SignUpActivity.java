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

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.wit.ie.doolysv2.R;

public class SignUpActivity extends AppCompatActivity {


    protected EditText myusername;
    protected EditText myemail;
    protected EditText mypassword;
    protected Button mybutton;
    protected Button myloginbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);



        //initializing local variables to xml ids
        myusername = (EditText)findViewById(R.id.name);
        myemail = (EditText)findViewById(R.id.email);
        mypassword = (EditText)findViewById(R.id.password);
        mybutton = (Button)findViewById(R.id.btnRegister);
        myloginbutton = (Button)findViewById(R.id.btnLinkToLoginScreen);

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get user particulars and save to parse
                String username = myusername.getText().toString().trim();
                String email = myemail.getText().toString().trim();
                String password = mypassword.getText().toString().trim();


                //store in parse
                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setEmail(email);
                user.setPassword(password);
                user.signUpInBackground(new SignUpCallback() {


                    @Override
                    public void done(ParseException e) {

                        if (e == null) {
                            Toast.makeText(SignUpActivity.this, "Successful Sign Up, Welcome!", Toast.LENGTH_LONG).show();

                            Intent main = new Intent(SignUpActivity.this,MainActivity.class);
                            startActivity(main);
                            finish();
                        } else {
                            //Error dialog box
                            AlertDialog.Builder errorMessage = new AlertDialog.Builder(SignUpActivity.this);
                            errorMessage.setMessage(e.getMessage());
                            errorMessage.setTitle("Error Signing in - please ensure all fields are filled in correctly!");
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

        myloginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Login = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(Login);
            }
        });



    }
    //disable back button
    @Override
    public void onBackPressed() {
    }



}








