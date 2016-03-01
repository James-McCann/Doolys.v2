package com.wit.ie.doolysv2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;
import com.wit.ie.doolysv2.R;

public class AddMenuItemActivity extends AppCompatActivity {


    protected EditText mfoodname;
    protected EditText mfoodimagelink;
    protected EditText mfoodprice;
    protected EditText mfooddescription;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu_item);


        //Setting the size of the pop up/////////////////////////////////
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));
        //////////////////////////////////////////////////////////////////


        //initializing text and buttons
        mfoodname = (EditText)findViewById(R.id.addFoodname);
        mfoodimagelink = (EditText)findViewById(R.id.addFoodIcon);
        mfoodprice = (EditText)findViewById(R.id.addFoodPrice);
        mfooddescription = (EditText)findViewById(R.id.addFoodDescription);
        addButton =(Button)findViewById(R.id.btnAdd);

        //Listener set on add button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(AddMenuItemActivity.this, "Menu Item Added", Toast.LENGTH_LONG).show();

                //get user details and convert toString
                String foodname = mfoodname.getText().toString().trim();
                String foodimage = mfoodimagelink.getText().toString().trim();
                String foodprice = mfoodprice.getText().toString().trim();
                String fooddescription = mfooddescription.getText().toString().trim();



                ParseObject addMenuItem = new ParseObject("FoodItems");
                addMenuItem.put("name", foodname);
                addMenuItem.put("imageLink", foodimage);
                addMenuItem.put("price", foodprice);
                addMenuItem.put("description", fooddescription);
                addMenuItem.saveInBackground();

                finish();



            }
        });


    }

}
