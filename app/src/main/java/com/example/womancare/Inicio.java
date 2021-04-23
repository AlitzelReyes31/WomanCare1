package com.example.womancare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

public class Inicio extends AppCompatActivity {

    TextView tv_registrar;
    private View btn_log;
    private EditText et_usuario;
    private EditText et_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_registrar= (TextView) findViewById(R.id.tv_registratr);
        et_usuario= (EditText)findViewById(R.id.TV_usu);
        et_password= (EditText) findViewById(R.id.TV_pas);

        btn_log = (Button)findViewById(R.id.Btn_iniciar);


        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(Inicio.this,Registro.class);
                Inicio.this.startActivity(intentReg);
            }
        });

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = et_usuario.getText().toString();
                final String password = et_password.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success ){

                                String nombre = jsonResponse.getString("nombre");
                                int edad = jsonResponse.getInt("edad");

                                Intent intent= new Intent(Inicio.this,MainActivity.class);
                                intent.putExtra("nombre",nombre);
                                intent.putExtra("username",username);
                                intent.putExtra("password",password);
                                intent.putExtra("edad",edad);

                                Inicio.this.startActivity(intent);
                            }else {
                                AlertDialog.Builder builder=new AlertDialog.Builder(Inicio.this);
                                builder.setMessage("ERROR EN EL LOGIN")
                                        .setNegativeButton("Retry",null)
                                        .create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                LoginRequest loginRequest = new LoginRequest(username,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(Inicio.this);
                queue.add(loginRequest);

            }
        });


    }

    private void lanzarAcercaDe(Object o) {
    }




}
