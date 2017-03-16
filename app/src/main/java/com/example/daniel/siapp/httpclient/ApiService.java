package com.example.daniel.siapp.httpclient;

import com.example.daniel.siapp.models.Medidas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("temperature")
    Call<Medidas> getMedidas();

}
