package com.finalproject.parkbnb;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParkingFragmentVertical extends Fragment {

    ListView places;
    ListView prices;
    ImageButton searchButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_parking, container, false);

        places = (ListView) rootView.findViewById(R.id.parkingspotslist);
        prices = (ListView) rootView.findViewById(R.id.priceslist);
        searchButton = (ImageButton) rootView.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String[] values = new String[] { "Motohaus",
                        "SFMTA Fifth & Mission Parking",
                        "Hearst Apartments",
                        "Jessie Square Garage",
                        "AY Parking ",
                        "Central Parking",
                        "Soiree Valet Parking Service",
                        "Priority Parking"

                };
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, android.R.id.text1, values);
                places.setAdapter(adapter);
                String[] price = new String[] { "$18",
                        "$21", "$23", "$19", "$35", "$29", "$31", "$25"

                };
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_list_item_1, android.R.id.text1, price);
                prices.setAdapter(adapter2);

            }
        });


        return rootView;
    }


}
