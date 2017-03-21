
package com.example.daniel.siapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Medidas {

    @SerializedName("medidas")
    @Expose
    private List<Medida> medidas = null;

    public List<Medida> getMedidas() {
        return medidas;
    }

    public void setMedidas(List<Medida> medidas) {
        this.medidas = medidas;
    }

}
