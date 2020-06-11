package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

public class login extends AppCompatActivity {

    EditText edtUsuario,edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsuario=findViewById(R.id.edtUsuario);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);
        cargarPreferencias();


        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                validarusuario("http://192.168.0.17:8080/android/obtener.php");
            }
        });

    }
  //  private void updateAndroidSecurityProvider() { try { ProviderInstaller.installIfNeeded(this); } catch (Exception e) { e.getMessage(); } }

    private void validarusuario(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, response -> {
            //stringRequest
            if(response.isEmpty()) {
                Toast.makeText(login.this, "Usuario o contrasena incorrecta" , Toast.LENGTH_LONG).show();

            }
                else
                {
                    View view = findViewById(android.R.id.content);
                    Toast.makeText(login.this, "Bienvenido", Toast.LENGTH_LONG).show();
                   // Snackbar snackbar = Snackbar.make(getView(), "Message is deleted", Snackbar.LENGTH_SHORT);
                    guardarPreferencias();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }

        }, error -> Toast.makeText(login.this, error.toString(), Toast.LENGTH_SHORT).show()){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
               // parametros.put("correo", edtUsuario.getText().toString());
               // parametros.put("contrasena", edtPassword.getText().toString());
                parametros.put("correo", edtUsuario.getText().toString());
                parametros.put("contrasena", edtPassword.getText().toString());
                Log.i("Mensajejdnejfnekedfn", String.valueOf(parametros));

                return parametros;

            }
        };

        RequestQueue requestQueque = Volley.newRequestQueue(this);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5*DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 0, 0));
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(0, 0, 0));
        requestQueque.add(stringRequest);

    }

    private void cargarPreferencias(){
        SharedPreferences preferencias = getSharedPreferences("credencial", Context.MODE_PRIVATE);

        String user = preferencias.getString("user","No existe la informacion");
        edtUsuario.setText(user);
    }

    private void guardarPreferencias(){
        SharedPreferences preferencias = getSharedPreferences("credencial", Context.MODE_PRIVATE);

        String user = edtUsuario.getText().toString();

        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("user",user);

        edtUsuario.setText(user);

        editor.commit();
    }
}
