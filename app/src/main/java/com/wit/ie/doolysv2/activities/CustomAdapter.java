//package com.wit.ie.doolysv2.activities;
//
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.parse.ParseFile;
//import com.parse.ParseImageView;
//import com.parse.ParseQuery;
//import com.parse.ParseQueryAdapter;
//import com.wit.ie.doolysv2.R;
//import com.wit.ie.doolysv2.model.FoodItems;
//
//public class CustomAdapter extends ParseQueryAdapter<FoodItems> {
//
//    public CustomAdapter(Context context) {
//        super(context, new ParseQueryAdapter.QueryFactory<FoodItems>() {
//            public ParseQuery<FoodItems>create() {
//                ParseQuery<FoodItems> query = ParseQuery.getQuery(FoodItems.class);
//                return query;
//            }
//        });
//    }
//
//
//    // Customize the layout by overriding getItemView
//    @Override
//    public View getItemView(FoodItems object, View v, ViewGroup parent) {
//        if (v == null) {
//            v = View.inflate(getContext(), R.layout.row, null);
//        }
//
//        super.getItemView(object, v, parent);
//
//        // Add and download the icon
//        ParseImageView todoImage = (ParseImageView) v.findViewById(R.id.foodIcon);
//        ParseFile imageFile = object.getParseFile("icon");
//        if (imageFile != null) {
//            todoImage.setParseFile(imageFile);
//            todoImage.loadInBackground();
//        }
//
//        // Add the name view
//        TextView nameTextView = (TextView) v.findViewById(R.id.foodName);
//        nameTextView.setText(object.getString("name"));
//
//        // Add the price view
//        TextView priceTextView = (TextView) v.findViewById(R.id.foodPrice);
//        priceTextView.setText(object.getString("price"));
//
//        // Add the description view
//        TextView descriptionTextView = (TextView) v.findViewById(R.id.foodDesc);
//        descriptionTextView.setText(object.getString("description"));
//
//
//        return v;
//    }
//
//
//}
