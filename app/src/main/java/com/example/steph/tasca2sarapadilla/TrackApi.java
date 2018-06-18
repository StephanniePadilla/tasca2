package com.example.steph.tasca2sarapadilla;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TrackApi {

    @GET("/funciones/listaUsuarios")
    Call<List<Usuario>> listaUsuarios();

    /*@GET("/books/{id}")
    Call<Book> consultarBook(@Path("id") String _id);*/

}
