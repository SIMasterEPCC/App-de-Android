package com.example.daniel.siapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.daniel.siapp.httpclient.ApiClient;
import com.example.daniel.siapp.httpclient.ApiService;
import com.example.daniel.siapp.models.Medidas;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        doRequest();
    }

    private void findViews() {
        list = (RecyclerView) findViewById(R.id.list);
    }

    private void doRequest() {
        ApiService apiService = ApiClient.createRetrofitService(ApiService.class, ApiService.END_POINT);
        Call<Medidas> aa = apiService.getMedidas();
        aa.enqueue(new Callback<Medidas>() {
            @Override
            public void onResponse(Call<Medidas> call, Response<Medidas> response) {
                showMedidas(response.body());
            }

            @Override
            public void onFailure(Call<Medidas> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "An error has ocurred", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showMedidas(Medidas medidas) {
        MedidasAdapter adapter = new MedidasAdapter(medidas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        list.setHasFixedSize(true);
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);
    }
}
