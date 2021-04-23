package com.example.womancare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class Registro extends AppCompatActivity implements View.OnClickListener {

    EditText etnombre,etusuario, etpassword, etedad;
    Button btn_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etnombre=findViewById(R.id.EditT_nombre);
        etusuario=findViewById(R.id.EditT_ususario);
        etpassword=findViewById(R.id.EditT_password);
        etedad=findViewById(R.id.EditT_edad);
        btn_registrar=findViewById(R.id.Btn_registrar);

        btn_registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String nombre=etnombre.getText().toString();
        final String username=etusuario.getText().toString();
        final String password=etpassword.getText().toString();
        final int edad= Integer.parseInt(etedad.getText().toString());
        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonReponse = new JSONObject(response);
                    boolean success=jsonReponse.getBoolean("success");

                    if(success){
                        Intent intent= new Intent(Registro.this,MainActivity.class);
                        Registro.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder=new AlertDialog.Builder(Registro.this);
                        builder.setMessage("ERROR EN EL REGISTRO")
                                .setNegativeButton("Retry",null)
                                .create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        RegisterRequest registerRequest= new RegisterRequest(nombre,username,password,edad, respoListener);

        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);


    }
}
