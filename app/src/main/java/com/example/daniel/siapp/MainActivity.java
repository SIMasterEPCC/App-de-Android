package com.example.daniel.siapp;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
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
    private SwipeRefreshLayout swipeRefreshContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        init();
    }

    private void init() {
        swipeRefreshContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                doRequest();
            }
        });
        swipeRefreshContainer.setColorSchemeColors(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        doRequest();
    }

    private void findViews() {
        list = (RecyclerView) findViewById(R.id.list);
        swipeRefreshContainer = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_container);
    }

    private void doRequest() {
        ApiService apiService = ApiClient.createRetrofitService(ApiService.class, ApiService.END_POINT);
        Call<Medidas> aa = apiService.getMedidas();
        aa.enqueue(new Callback<Medidas>() {
            @Override
            public void onResponse(Call<Medidas> call, Response<Medidas> response) {
                showMedidas(response.body());
                swipeRefreshContainer.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<Medidas> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "An error has ocurred", Toast.LENGTH_SHORT).show();
                swipeRefreshContainer.setRefreshing(false);
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
