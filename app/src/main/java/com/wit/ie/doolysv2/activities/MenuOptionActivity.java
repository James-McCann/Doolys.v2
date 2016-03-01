package com.wit.ie.doolysv2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import com.wit.ie.doolysv2.R;

public class MenuOptionActivity extends AppCompatActivity {



    Button updateBtn;
    Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_option);

        //Setting the size of the pop up/////////////////////////////////
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));
        //////////////////////////////////////////////////////////////////


        updateBtn =(Button)findViewById(R.id.update);
        deleteBtn =(Button)findViewById(R.id.delete);

        updateBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"Button Pressed",Toast.LENGTH_SHORT).show();
                Intent addMenuItem = new Intent(MenuOptionActivity.this, UpdateMenuItemActivity.class);
                startActivity(addMenuItem);

            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"Button Pressed",Toast.LENGTH_SHORT).show();
                Intent addMenuItem = new Intent(MenuOptionActivity.this, DeleteMenuItemActivity.class);
                startActivity(addMenuItem);

            }
        });


    }


}
