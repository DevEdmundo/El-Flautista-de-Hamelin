package com.deved.mainactivity.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.deved.alexis.MainActivity;
import com.deved.alexis.activities.LoginActivity;

import java.util.HashMap;

public class SessionManager {

    SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

//    LOGEO
    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String EMAIL = "EMAIL";

//    SERVICIOS
    public static final String TITULO="TITULO";
    public static final String DETALLE="DETALLE";
    public static final String PRECIO="PRECIO";
    public static final String IMAGEN="IMAGEN";
    public static final String IDBARBERO="IDBARBERO";
    public static final String FECHA="FECHA";
    public static final String HORA="HORA";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSessionLogin(String email){
        //TODO MODIFICAR ESTO JUNTO CON RETROFIT, PARA TRAER EL EMAIL, NOMBRE, Y ALGUNOS DATOS MÁS DEL USUARIO PARA LA PARTE DE MI PERFIL. PERO POR EL MOMENTO SE USA DATOS EN DURO

        editor.putBoolean(LOGIN, true);
        editor.putString(EMAIL, email);
        editor.apply();
    }


    public void sharedServicios(String titulo, String detalle, String precio,String imagen,String idBarbero, String fecha,String hora){
        editor.putString(TITULO,titulo);
        editor.putString(DETALLE,detalle);
        editor.putString(PRECIO,precio);
        editor.putString(IMAGEN,imagen);
        editor.putString(IDBARBERO,idBarbero);
        editor.putString(FECHA,fecha);
        editor.putString(HORA,hora);
        editor.apply();
    }

    public HashMap<String, String>getServicioDetalles(){

        HashMap<String,String> servicios = new HashMap<>();
        servicios.put(TITULO,sharedPreferences.getString(TITULO,null));
        servicios.put(DETALLE,sharedPreferences.getString(DETALLE,null));
        servicios.put(PRECIO,sharedPreferences.getString(PRECIO,null));
        servicios.put(IMAGEN,sharedPreferences.getString(IMAGEN,null));
        servicios.put(IDBARBERO,sharedPreferences.getString(IDBARBERO,null));
        servicios.put(FECHA,sharedPreferences.getString(FECHA,null));
        servicios.put(HORA,sharedPreferences.getString(HORA,null));
        return servicios;
    }


    public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin(){

        if (!this.isLoggin()){
            Intent i = new Intent(context, LoginActivity.class);
            context.startActivity(i);
            ((MainActivity) context).finish();
        }
    }

    public HashMap<String, String> getUserDetail(){

        HashMap<String, String> user = new HashMap<>();
        user.put(EMAIL, sharedPreferences.getString(EMAIL, null));

        return user;
    }

    public void logout(){

        editor.clear();
        editor.commit();
        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);
        ((MainActivity) context).finish();

    }
}
