package com.deved.mainactivity.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deved.mainactivity.R;
<<<<<<< HEAD

public class InfografiaFragment extends Fragment {


=======
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfografiaFragment extends Fragment  {

    private View rootView;
    private MapView mapView;
    private GoogleMap gMap;
>>>>>>> cf075817482607c8c8122de0717e91761f275e27

    public InfografiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD
        return inflater.inflate(R.layout.fragment_infografia, container, false);
    }

=======
        View view = inflater.inflate(R.layout.fragment_infografia, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


>>>>>>> cf075817482607c8c8122de0717e91761f275e27
}
