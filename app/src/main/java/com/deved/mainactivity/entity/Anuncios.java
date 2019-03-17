package com.deved.mainactivity.entity;

public class Anuncios {

    private int PK_CODIGO;
    private String titulo;
    private String detalle;
    private String imagen;


    public int getPK_CODIGO() {
        return PK_CODIGO;
    }

    public void setPK_CODIGO(int PK_CODIGO) {
        this.PK_CODIGO = PK_CODIGO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
