
package com.example.daniel.siapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medida {

    @SerializedName("Temperatura")
    @Expose
    private Integer temperatura;

    @SerializedName("Fecha")
    @Expose
    private String fecha;

    @SerializedName("Dispositivo")
    @Expose
    private Integer dispositivo;

    @SerializedName("Humedad")
    @Expose
    private Integer humedad;

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Integer dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Integer getHumedad() {
        return humedad;
    }

    public void setHumedad(Integer humedad) {
        this.humedad = humedad;
    }

}
