//package com.wit.ie.doolysv2.model;
//
//import com.parse.ParseClassName;
//import com.parse.ParseFile;
//import com.parse.ParseObject;
//import com.parse.ParseQuery;
//
//@ParseClassName("MenuItems")
//public class FoodItems extends ParseObject{
//
//    public String getName(){
//        return getString("Name");
//    }
//    public void setName(String name){
//        put ("Name", name);
//    }
//
//    public ParseFile getParseFile(){
//        return getParseFile("icon");
//    }
//    public void setParseFile(ParseFile icon){
//        put ("Icon", icon);
//    }
//
//
//    public String getPrice(){
//        return getString("Price");
//    }
//
//    public void setPrice(String price){
//        put ("Price", price);
//    }
//
//    public String getDescription(){
//        return getString("Description");
//    }
//
//    public void setDescription(String description){
//        put ("Description", description);
//    }
//
//    public String getObjectId(){
//        return getObjectId();
//    }
//
//    public void setObjectId(String objectId){
//        put("objectId",objectId);
//    }
//
//    public static ParseQuery<FoodItems> getQuery(){
//        return ParseQuery.getQuery(FoodItems.class);
//    }
//
//}
