package com.wit.ie.doolysv2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;
import com.wit.ie.doolysv2.R;
import com.wit.ie.doolysv2.model.Food;

import java.util.ArrayList;
import java.util.List;


public class CustomerFragment extends Fragment{

    Food food;
    private ListView mListView;
    //private List<String> mMenuList;
    private List<Food> mFoodList;
//    private Button addMenuItem;
    private FloatingActionButton addMenuItem;

    private SwipeRefreshLayout mSwipeRefreshLayout;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.activity_customer_fragment, container, false);
        mListView = (ListView) fragmentView.findViewById(R.id.myListView);




        //Swipe Refresh/////////////////////////////////////////////////////////////////////////////////////Swipe Refresh
        mSwipeRefreshLayout = (SwipeRefreshLayout)fragmentView.findViewById(R.id.swipeRefresh);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.orange,R.color.green,R.color.blue);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){


            @Override
            public void onRefresh() {
                //Toast.makeText(getActivity(),"Refreshed Menu List",Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(true);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                        RefreshFrag();
                    }
                }, 3000);


            }
        });



        //addMenuItems button//////////////////////////////////////////////////////////////////////////////add button FAB
        addMenuItem = (FloatingActionButton)fragmentView.findViewById(R.id.addButton);
        //addMenuItems button Listener
        addMenuItem.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),"Button Pressed",Toast.LENGTH_SHORT).show();
                Intent addMenuItem = new Intent(getActivity(), AddMenuItemActivity.class);
                startActivity(addMenuItem);

            }
        });



        //Fetching menu items from FoodItems Database on Parse///////////////////////////////////////////////Calling from Parse Database
        mFoodList = new ArrayList<Food>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("FoodItems");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> foodParseList, ParseException e) {
                if (e == null) {

                    for (ParseObject parseObject : foodParseList) {

                        String name = (String) parseObject.get("name");
                        String imageLink = (String) parseObject.get("imageLink");
                        String price = (String) parseObject.get("price");
                        String description = (String) parseObject.get("description");
                        Food food = new Food(name, imageLink, price, description);
                        mFoodList.add(food);
                    }

                    mListView.setAdapter(new MyAdapter());
                    //MyAdapter.notifyDataSetChanged();


                    mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Intent optionMenuItem = new Intent(getActivity(), MenuOptionActivity.class);
                            startActivity(optionMenuItem);
                        }

                    });


                    //Log.d("score", "Retrieved " + menuParseList.size() + " scores");
                } else {
                    Toast.makeText(getActivity(), "Error " + e, Toast.LENGTH_SHORT).show();
                }
            }
        });


        return fragmentView;

    }//End of onCreate view




    //Simple method to refresh fragment called in Swipe Refresh
    public void RefreshFrag(){
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.detach(this).attach(this).commit();

    }


    private class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return mFoodList.size();
        }

        @Override
        public Object getItem(int position) {
            return mFoodList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View rowView = getActivity().getLayoutInflater().inflate(R.layout.firstrow, null);

            Food rowFood = mFoodList.get(position);

            TextView foodNameRow = (TextView) rowView.findViewById(R.id.foodName);
            foodNameRow.setText(rowFood.getName());

            ImageView foodIconView = (ImageView)rowView.findViewById(R.id.foodIcon);
            Picasso.with(getActivity()).load(rowFood.getImageLink()).into(foodIconView);

            TextView foodPriceRow = (TextView) rowView.findViewById(R.id.foodPrice);
            foodPriceRow.setText(rowFood.getPrice());

            TextView foodDescRow = (TextView) rowView.findViewById(R.id.foodDesc);
            foodDescRow.setText(rowFood.getDescription());


            return rowView;
            }
    }


}





