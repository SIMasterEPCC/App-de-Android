
package com.example.daniel.siapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medidas {

    @SerializedName("temperature")
    @Expose
    private List<Temperature> temperature = null;

    public List<Temperature> getTemperature() {
        return temperature;
    }

    public void setTemperature(List<Temperature> temperature) {
        this.temperature = temperature;
    }

}
