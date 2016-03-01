package com.wit.ie.doolysv2.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.parse.ParseUser;
import com.wit.ie.doolysv2.R;


public class MainActivity extends AppCompatActivity {

    DrawerLayout myDrawerLayout;
    NavigationView myNavigationView;
    FragmentManager myFragmentManager;
    FragmentTransaction myFragmentTransaction;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {


            //PushService.setDefaultPushCallback(this, MainActivity.class);

            //Setup drawer layout and the navigation view
            myDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
            myNavigationView = (NavigationView) findViewById(R.id.navview);


            //Inflate first fragment
            //Inflating the tabfragment as the first fragment
            myFragmentManager = getSupportFragmentManager();
            myFragmentTransaction = myFragmentManager.beginTransaction();
            myFragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();


            myNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    myDrawerLayout.closeDrawers();


                    if (menuItem.getItemId() == R.id.nav_web) {
                        FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.containerView, new WebFragment()).commit();

                    }

                    if (menuItem.getItemId() == R.id.nav_customer) {
                        FragmentTransaction xfragmentTransaction = myFragmentManager.beginTransaction();
                        xfragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                    }

                    if (menuItem.getItemId() == R.id.nav_logout) {
                        ParseUser.logOut();
                        Intent login = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(login);

                    }

                    return false;
                }

            });


            //Toolbar toggle support
            android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
            //toolbar.setLogo(R.drawable.ic_share);
            //toolbar.setLogo(R.drawable.ic_share);


            ActionBarDrawerToggle myDrawerToggle = new ActionBarDrawerToggle(this, myDrawerLayout, toolbar, R.string.app_name, R.string.app_name);

            myDrawerLayout.setDrawerListener(myDrawerToggle);

            myDrawerToggle.syncState();


        } else {
            // if no one is logged show login screen
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }


    }//end of onCreate


    //Back button exit dialog
    //http://stackoverflow.com/questions/20591959/android-quit-application-when-press-back-button
    private boolean exit = true;
    @Override
    public void onBackPressed() {
        if (exit) {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                    .setMessage("Are you sure?")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();
                        }
                    }).setNegativeButton("no", null).show();
        }

    }



}