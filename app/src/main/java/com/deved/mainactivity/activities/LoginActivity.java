package com.deved.mainactivity.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.deved.mainactivity.BaseActivity;
import com.deved.mainactivity.R;
import com.deved.mainactivity.util.SessionManager;
import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Required;
import com.mobsandgeeks.saripaar.annotation.TextRule;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends AppCompatActivity implements Validator.ValidationListener {

    @BindView(R.id.log_edt_correo)
    @Required(order = 1,message = "Campo obligatorio")
    @Email(order = 2,message = "Debe de ingresar un correo Valido")
    EditText edt_correo;

    @BindView(R.id.log_edt_password)
    @Required(order = 3,message = "Campo obligatorio")
    @TextRule(order=4,minLength = 6,maxLength = 10,message ="La contraseña debe se entre 6 y 10 digitos" )
    EditText edt_password;

    Validator validator;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        sessionManager = new SessionManager(this);

        validator = new Validator(this);
        validator.setValidationListener(this);
    }


    @OnClick(R.id.log_btn_ingresar)
    public void autenticar(){
        validator.validate();
    }

    @Override
    public void onValidationSucceeded() {

        //TODO TRAER CON RETROFIT LOS DATOS REALES, RECUERDA QUE LA SESSION LO ESTÁS HACIENDO CON DATOS EN DURO

        String usuario=edt_correo.getText().toString();
        String contrasenia=edt_password.getText().toString();

        if(usuario.equals("Edmundo@gmail.com")&&contrasenia.equals("123456")){

            sessionManager.createSessionLogin(usuario);

            Intent i = new Intent(LoginActivity.this, BaseActivity.class);
            startActivity(i);
            finish();


        }else{

            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Oops...")
                    .setContentText("Usuario o contraseña incorrecta")
                    .show();
        }
    }

    @Override
    public void onValidationFailed(View failedView, Rule<?> failedRule) {

        final String failureMessage = failedRule.getFailureMessage();
        if (failedView instanceof EditText) {
            EditText failed = (EditText) failedView;
            failed.requestFocus();
            failed.setError(failureMessage);
        } else {
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Oops...")
                    .setContentText("'Error:"+failureMessage+"!")
                    .show();

        }
    }
}
