package com.wit.ie.doolysv2.activities;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.wit.ie.doolysv2.R;


public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        //ParseObject.registerSubclass(FoodItems.class);
        Parse.initialize(this, getString(R.string.ParseId), getString(R.string.ParseClientId));
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
