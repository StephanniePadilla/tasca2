package com.example.steph.tasca2sarapadilla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Main menu");

        pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);
    }

    public void listaLibros(View view){

        //inici de la tasca
        pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);
        pb1.setVisibility(ProgressBar.VISIBLE);

        Intent intentOj = new Intent(MainActivity.this, PartidaList.class);
        startActivity(intentOj);

        //al final de la tasca
        pb1.setVisibility(ProgressBar.INVISIBLE);

    }

    public void detalleUsuario (View view){

        //inici de la tasca
        pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);
        pb1.setVisibility(ProgressBar.VISIBLE);

        Intent intentOj = new Intent(MainActivity.this, UsuarioDetalle.class);
        startActivity(intentOj);

        //al final de la tasca
        pb1.setVisibility(ProgressBar.INVISIBLE);

    }
}
