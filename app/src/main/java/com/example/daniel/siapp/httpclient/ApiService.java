package com.example.daniel.siapp.httpclient;

import com.example.daniel.siapp.models.Medidas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    String END_POINT = "http://158.49.112.86:1521/";

    @GET("medidas")
    Call<Medidas> getMedidas();

}
