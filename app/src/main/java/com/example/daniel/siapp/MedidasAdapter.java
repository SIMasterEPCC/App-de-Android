package com.example.daniel.siapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daniel.siapp.models.Medida;
import com.example.daniel.siapp.models.Medidas;

import java.util.List;

public class MedidasAdapter extends RecyclerView.Adapter<MedidasAdapter.ListHolder> {

    List<Medida> items;

    public MedidasAdapter(Medidas medidas) {
        this.items = medidas.getMedidas();
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size() - 1;
    }

    public static class ListHolder extends RecyclerView.ViewHolder {

        TextView date;
        TextView device;
        TextView temperature;
        TextView humidity;

        public ListHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            device = (TextView) itemView.findViewById(R.id.device);
            temperature = (TextView) itemView.findViewById(R.id.temperature);
            humidity = (TextView) itemView.findViewById(R.id.humidity);
        }

        public void bind(Medida item) {
            date.setText(String.valueOf(item.getFecha()));
            device.setText(String.valueOf(item.getDispositivo()));
            temperature.setText(String.valueOf(item.getTemperatura()));
            humidity.setText(String.valueOf(item.getHumedad()));
        }
    }
}
