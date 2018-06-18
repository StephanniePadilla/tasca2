package com.example.steph.tasca2sarapadilla;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TrackApi {

    @GET("/funciones/listaUsuarios")
    Call<List<Usuario>> listaUsuarios();

    /*@POST("funciones/unUsuario")
        //@FormUrlEncoded
    Call<Usuario> consultarUnUsuario (@Body Usuario u);*/

    /*@GET("/funciones/unUsuario/{idemail}")
    Call<Usuario> consultarUnUsuario(@Path("idemail") String idemail);*/

}
