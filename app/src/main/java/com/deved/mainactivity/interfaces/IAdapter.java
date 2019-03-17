package com.deved.mainactivity.interfaces;

import com.deved.mainactivity.entity.Anuncios;

import java.util.ArrayList;

public interface IAdapter {

    void inicializarAdapter(ArrayList<Anuncios> list_anuncios);
    void poblarInformacion();
}
