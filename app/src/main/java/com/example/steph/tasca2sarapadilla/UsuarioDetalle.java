package com.example.steph.tasca2sarapadilla;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class UsuarioDetalle extends AppCompatActivity {

    public static final String BASE_URL = "http://192.168.1.41:8080/myapp/";

    private TrackApi trackServices;
    String tag = "Events";

    private Call<List<Usuario>> callUser;

    ProgressBar pb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_detalle);

        pb1 = (ProgressBar) findViewById(R.id.indeterminateBar);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final EditText et = (EditText)findViewById(R.id.idemail_txt);
        final String idEmail = et.getText().toString().trim();

        trackServices = retrofit.create(TrackApi.class);

        callUser = trackServices.listaUsuarios();
        callUser.enqueue(new Callback<List<Usuario>>() {

            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                int statusCode = response.code();

                if (response.isSuccessful()) {

                    Toast.makeText(UsuarioDetalle.this, "Peticion correcta", Toast.LENGTH_LONG).show();
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode) + "resultado:");

                    List<Usuario> userList = response.body();

                    for(Usuario user: userList){
                        if (user.getEmail().equals(idEmail)) {
                            ListView lv = (ListView) findViewById(R.id.followers_list);
                            UsuarioDetalleArrayAdapter uaa = new UsuarioDetalleArrayAdapter(getApplicationContext(), userList);
                            lv.setAdapter(uaa);

                             pb1.setVisibility(ProgressBar.INVISIBLE);//al final de la tasca

                             //Intent intentOj = new Intent(Peticiones.this, Peticiones.class);
                             //startActivity(intentOj);
                        }
                    }
                } else {
                    //al final de la tasca
                    pb1.setVisibility(ProgressBar.INVISIBLE);
                    Log.d("onResponse", "onResponse. Code" + Integer.toString(statusCode));
                    Toast.makeText(UsuarioDetalle.this, "Error en la respuesta", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                //al final de la tasca
                pb1.setVisibility(ProgressBar.INVISIBLE);
                // log error here since request failed
                Log.d("Request: ", "error loading API" + t.toString());
            }
        });
    }
}
