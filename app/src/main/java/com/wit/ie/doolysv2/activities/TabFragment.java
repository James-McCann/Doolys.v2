package com.wit.ie.doolysv2.activities;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wit.ie.doolysv2.R;


public class TabFragment extends Fragment{

    public static TabLayout myTabLayout;
    public static ViewPager myViewPager;
    public static int items = 3 ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


         //Inflate tab_layout and setup Views.
        View x =  inflater.inflate(R.layout.activity_tablayout,null);
        myTabLayout = (TabLayout) x.findViewById(R.id.tabs);
        myViewPager = (ViewPager) x.findViewById(R.id.viewpager);


        //Set an Adapter for the View Pager
        myViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        myTabLayout.post(new Runnable() {
            @Override
            public void run() {
                myTabLayout.setupWithViewPager(myViewPager);
            }
        });

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }


        //Return fragment with respect to Position .
        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new CustomerFragment();
                case 1 : return new PromoFragment();
                case 2 : return new MapFragment();

            }
            return null;
        }

        @Override
        public int getCount() {

            return items;

        }

       //This method returns the title of the tab according to the position.
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Menu";
                case 1 :
                    return "Promotions";
                case 2 :
                    return "Map";
            }
            return null;
        }
    }

}