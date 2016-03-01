package com.wit.ie.doolysv2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.wit.ie.doolysv2.R;

public class UpdateMenuItemActivity extends AppCompatActivity {

    protected EditText mfoodname;
    protected EditText mfoodprice;
    private Button mupdateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_menu_item);


        //Setting the size of the pop up/////////////////////////////////
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));
        //////////////////////////////////////////////////////////////////


        mfoodname = (EditText) findViewById(R.id.updateFoodName);
        mfoodprice = (EditText) findViewById(R.id.updateFoodPrice);
        mupdateButton = (Button) findViewById(R.id.UpdateButton);

        mupdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Toast.makeText(DeleteMenuItemActivity.this, "Menu Item deleted", Toast.LENGTH_LONG).show();

                //get user details and convert toString
                String upfoodname = mfoodname.getText().toString().trim();
                final String upfoodprice = mfoodprice.getText().toString().trim();



                ParseQuery<ParseObject> query = ParseQuery.getQuery("FoodItems");
                query.whereEqualTo("name", upfoodname);
                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject parseObject, ParseException e) {

                        if (e == null) {

                            parseObject.put("price", upfoodprice);
                            parseObject.saveInBackground();
                            Toast.makeText(UpdateMenuItemActivity.this, "Menu Item Price Updated", Toast.LENGTH_SHORT).show();
                            finish();

                        } else {
                            //Log.d("Error", e.getMessage());
                            Toast.makeText(UpdateMenuItemActivity.this, "Ensure correct details and try again", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });



    }


}
