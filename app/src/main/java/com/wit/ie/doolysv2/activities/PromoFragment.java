package com.wit.ie.doolysv2.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.squareup.picasso.Picasso;
import com.wit.ie.doolysv2.R;
import com.wit.ie.doolysv2.model.Promotion;

import java.util.ArrayList;
import java.util.List;


public class PromoFragment extends Fragment {



    Promotion promotion;
    private ListView mListView;
    private List<Promotion> mPromotionList;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.activity_promo_fragment, container, false);
        mListView = (ListView) fragmentView.findViewById(R.id.myListView2);


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
        //Admob advertisement
        AdView mAdView = (AdView)fragmentView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mPromotionList = new ArrayList<Promotion>();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Promotion");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> promotionParseList, ParseException e) {
                if (e == null) {

                    for (ParseObject parseObject : promotionParseList) {

                        String name = (String) parseObject.get("promoname");
                        String imageLink = (String) parseObject.get("ImageLink");

                        Promotion promotion = new Promotion(name, imageLink);
                        mPromotionList.add(promotion);
                    }

                    mListView.setAdapter(new MyAdapter());

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
            return mPromotionList.size();
        }

        @Override
        public Object getItem(int position) {
            return mPromotionList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View rowView = getActivity().getLayoutInflater().inflate(R.layout.promorow, null);

            Promotion rowPromo = mPromotionList.get(position);

            TextView promoNameRow = (TextView) rowView.findViewById(R.id.promoName);
            promoNameRow.setText(rowPromo.getName());

            ImageView promoIconView = (ImageView)rowView.findViewById(R.id.promoIcon);
            Picasso.with(getActivity()).load(rowPromo.getImageLink()).into(promoIconView);



            return rowView;
        }
    }

}


