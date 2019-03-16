package com.deved.mainactivity.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deved.mainactivity.R;

<<<<<<< HEAD
public class InicioFragment extends Fragment {
=======
/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment implements OnMapReadyCallback {

    private View rootView;
    private MapView mapView;
    private GoogleMap gMap;
>>>>>>> cf075817482607c8c8122de0717e91761f275e27



    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_inicio, container, false);
        return rootView;

    }


        mapView = rootView.findViewById(R.id.map);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        LatLng place = new LatLng(-12.091069, -76.979845);
        gMap.addMarker(new MarkerOptions().position(place).title("Tu ubicación"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(place));
    }
}

