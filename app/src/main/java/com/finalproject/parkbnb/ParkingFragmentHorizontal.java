package com.finalproject.parkbnb;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParkingFragmentHorizontal extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    GoogleMap googleMap;
    ImageButton searchButton;
    Marker marker3;
    RelativeLayout relativelayout;
    LinearLayout bookscreen;
    Button book;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_parking_horizontal, container, false);

        relativelayout = (RelativeLayout) rootView.findViewById(R.id.relativelayout);
        bookscreen = (LinearLayout) rootView.findViewById(R.id.bookscreen);
        book = (Button) rootView.findViewById(R.id.booknow);
        searchButton = (ImageButton) rootView.findViewById(R.id.searchButton);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getActivity();
                new AlertDialog.Builder(context)
                        .setTitle("Book Parking")
                        .setMessage("Are you sure you want to book this parking?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
        relativelayout.setVisibility(View.VISIBLE);
        bookscreen.setVisibility(View.GONE);
        MapFragment mapFragment = new MapFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.map, mapFragment).commit();
        mapFragment.getMapAsync(this);





        return rootView;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.775627, -122.420767), 14.0f));

        // latitude and longitude
        googleMap.setOnMarkerClickListener(this);

        MarkerOptions marker = new MarkerOptions().position(new LatLng(37.775627, -122.420767)).title("MotoHaus $21");
        MarkerOptions marker2 = new MarkerOptions().position(new LatLng(37.778629, -122.420769)).title("SFMTA Fifth & Mission Parking $23");
        marker3 = googleMap.addMarker(new MarkerOptions().position(new LatLng(37.772627, -122.422567)).title("Hearst Apartments $19"));
        MarkerOptions marker4 = new MarkerOptions().position(new LatLng(37.788627, -122.421667)).title("Jessie Square Garage $35");
        MarkerOptions marker5 = new MarkerOptions().position(new LatLng(37.792627, -122.420567)).title("AY Parking $39");

        marker3.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
        googleMap.addMarker(marker);
        googleMap.addMarker(marker2);

        googleMap.addMarker(marker4);
        googleMap.addMarker(marker5);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if (marker.equals(marker3)){
            bookscreen.setVisibility(View.VISIBLE);
            relativelayout.setVisibility(View.GONE);

        }
        return false;
    }
}
