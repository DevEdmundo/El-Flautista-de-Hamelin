package com.deved.mainactivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.deved.mainactivity.fragments.InfografiaFragment;
import com.deved.mainactivity.fragments.InicioFragment;
import com.deved.mainactivity.interfaces.IMainActivity;
import com.deved.mainactivity.util.SessionManager;

public class BaseActivity extends AppCompatActivity  implements IMainActivity {

    Fragment fragment;
    SessionManager sessionManager;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_inicio:
                    fragment = new InicioFragment();
                    insertarFragment();
                    return true;
                case R.id.nav_empresa:
                    fragment = new InfografiaFragment();
                    insertarFragment();
                    return true;
                case R.id.nav_ofertas:
                    fragment = new OfertasFragment();
                    insertarFragment();
                    return true;
                case R.id.nav_ajustes:
                    fragment = new AjustesFragment();
                    insertarFragment();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragment = new InicioFragment();
        insertarFragment();

    }

    @Override
    public void insertarFragment() {
        if(fragment !=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedorTab,fragment).commit();
        }
    }
}
