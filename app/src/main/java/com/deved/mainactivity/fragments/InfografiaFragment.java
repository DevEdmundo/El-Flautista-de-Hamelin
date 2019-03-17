package com.deved.mainactivity.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deved.mainactivity.R;
import com.deved.mainactivity.adapters.AnunciosAdapter;
import com.deved.mainactivity.entity.Anuncios;
import com.deved.mainactivity.interfaces.IAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class InfografiaFragment extends Fragment implements IAdapter {


    @BindView(R.id.recycler_anuncios)
    RecyclerView recycler_servicios;

    ArrayList<Anuncios> list_anuncios;

    SweetAlertDialog pd;
    public InfografiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //

        View vista = inflater.inflate(R.layout.fragment_infografia, container, false);
        ButterKnife.bind(this,vista);

        poblarInformacion();

        return vista;

    }

    @Override
    public void inicializarAdapter(ArrayList<Anuncios> list_anuncios) {
        recycler_servicios.setAdapter(new AnunciosAdapter(getContext(),R.layout.item_anuncio,list_anuncios));
        recycler_servicios.setLayoutManager(new LinearLayoutManager(getContext()));

    }

    @Override
    public void poblarInformacion() {

        list_anuncios = new ArrayList<>();
        Anuncios anuncios = new Anuncios();
        anuncios.setTitulo("Vendo 10kg de botella");
        anuncios.setDetalle("Vendo 10kg de botella");
        list_anuncios.add(anuncios);
        inicializarAdapter(list_anuncios);
    }
}
