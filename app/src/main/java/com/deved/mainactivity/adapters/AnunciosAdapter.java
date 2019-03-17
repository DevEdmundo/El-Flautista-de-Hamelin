package com.deved.mainactivity.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.deved.mainactivity.R;
import com.deved.mainactivity.entity.Anuncios;
import com.deved.mainactivity.util.SessionManager;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AnunciosAdapter extends RecyclerView.Adapter<AnunciosAdapter.AnunciosAdapterViewHolder> {

    Context context;
    int item_anuncio;
    ArrayList<Anuncios> list_anuncios;

    SessionManager sessionManager;

    public AnunciosAdapter(Context context, int item_anuncio, ArrayList<Anuncios> list_anuncios) {
        this.context = context;
        this.item_anuncio = item_anuncio;
        this.list_anuncios = list_anuncios;
    }

    @NonNull
    @Override
    public AnunciosAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anuncio,parent,false);
        sessionManager = new SessionManager(context);
        return new AnunciosAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnunciosAdapterViewHolder holder, int position) {

        final Anuncios lista = list_anuncios.get(position);

        holder.anu_tv_titulo.setText(lista.getTitulo().toString().trim());
        holder.anu_tv_descripcion.setText(lista.getDetalle().toString().trim());


    }

    @Override
    public int getItemCount() {
        return list_anuncios.size();
    }


    public class AnunciosAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.anu_tv_descripcion)
        TextView anu_tv_descripcion;

        @BindView(R.id.anu_tv_titulo)
        TextView anu_tv_titulo;

        @BindView(R.id.anu_img_perfil)
        ImageView anu_img_perfil;

        public AnunciosAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
