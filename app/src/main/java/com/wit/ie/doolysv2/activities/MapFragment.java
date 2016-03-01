package com.wit.ie.doolysv2.activities;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends SupportMapFragment {



    //private GoogleMap googleMap;
    private final LatLng LOCATION_PARK = new LatLng(52.257532, -7.102771);
    private final LatLng LOCATION_MAIN = new LatLng(52.162373, -7.152750);
    private final LatLng LOCATION_STRAND = new LatLng(52.159768, -7.147631);


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        GoogleMap googleMap = getMap();

        googleMap.setMyLocationEnabled(true);
        //googleMap.
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(52.208487, -7.135598), 11));
        googleMap.getUiSettings().setCompassEnabled(true);


        MarkerOptions marker1 = new MarkerOptions();
        marker1.position(LOCATION_PARK).title("Doolys Park Rd. Waterford City" + "(051 309100)").snippet("Park Rd. Waterford City");
        googleMap.addMarker(marker1);


        MarkerOptions marker2 = new MarkerOptions();
        marker2.position(LOCATION_MAIN).title("Doolys Fresh Fish & Chips " + "(051 381529)").snippet("Main Rd. Tramore");
        googleMap.addMarker(marker2);

        MarkerOptions marker3 = new MarkerOptions();
        marker3.position(LOCATION_STRAND).title("Doolys Fresh Fish & Chips " + "(051 381012)").snippet("Strand Rd. Tramore");
        googleMap.addMarker(marker3);



    }


    //Map Functions
//    public void onClick_Park(View v) {
//        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_PARK, 15);
//        googleMap.animateCamera(update);
//        googleMap.addMarker(new MarkerOptions().position(LOCATION_PARK).title("Doolys Fresh Fish & Chips " + "(051 309100)").snippet("Park Rd. Waterford City"));
//
//    }
//
//    public void onClick_Main(View v) {
//
//        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_MAIN, 15);
//        googleMap.animateCamera(update);
//        googleMap.addMarker(new MarkerOptions().position(LOCATION_MAIN).title("Doolys Fresh Fish & Chips " + "(051 381529)").snippet("Main Rd. Tramore"));
//
//
//    }
//
//    public void onClick_Strand(View v) {
//
//        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(LOCATION_STRAND, 15);
//        googleMap.animateCamera(update);
//        googleMap.addMarker(new MarkerOptions().position(LOCATION_STRAND).title("Doolys Fresh Fish & Chips " + "(051 381012)").snippet("Strand Rd. Tramore"));
//
//
//    }


}