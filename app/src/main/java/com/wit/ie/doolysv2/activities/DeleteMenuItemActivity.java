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

public class DeleteMenuItemActivity extends AppCompatActivity {


    //   private Spinner spinner;
    protected EditText mfoodname;
    private Button mdeleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_menu_item);


//        spinner =(Spinner)findViewById(R.id.myspinner);
        mfoodname = (EditText) findViewById(R.id.deleteFoodName);
        mdeleteButton = (Button) findViewById(R.id.deleteButton);

        //Setting the size of the pop up/////////////////////////////////
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));
        //////////////////////////////////////////////////////////////////



        mdeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //Toast.makeText(DeleteMenuItemActivity.this, "Menu Item deleted", Toast.LENGTH_LONG).show();

                //get user details and convert toString
                String foodname = mfoodname.getText().toString().trim();
                ParseQuery<ParseObject> query = ParseQuery.getQuery("FoodItems");
                query.whereEqualTo("name", foodname);
                query.getFirstInBackground(new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject parseObject, ParseException e) {

                        if (e == null) {
                            try {
                                parseObject.delete();
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                            parseObject.deleteInBackground();
                            Toast.makeText(DeleteMenuItemActivity.this, "Menu Item Deleted", Toast.LENGTH_SHORT).show();
                            finish();

                        } else {
                            Toast.makeText(DeleteMenuItemActivity.this, "Ensure correct name and try again", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });


    }


}


