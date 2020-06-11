package com.example.proyectofinal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.proyectofinal.R;
import com.google.android.material.snackbar.Snackbar;

public class ubicacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
       /* Button button= findViewById(R.id.btnLogin);
         button.setOnClickListener(v -> {
            Intent facebook = new Intent(Intent.ACTION_VIEW);
            facebook.setData(Uri.parse("http://www.youtube.com/watch?v=0m_FHlRYqo0"));
            startActivity(facebook);
            Log.i("165","uiji");

    });*/
    }


    public void contactar(View v) {
        Log.i("sa", "dwdwdwdwdwdwdw");
        Intent facebook = new Intent(Intent.ACTION_VIEW);
        facebook.setData(Uri.parse("http://www.youtube.com/watch?v=0m_FHlRYqo0"));
        //startActivity(facebook);
        if (facebook.resolveActivity(getPackageManager()) != null) {
            startActivity(facebook);

        }
    }



}
