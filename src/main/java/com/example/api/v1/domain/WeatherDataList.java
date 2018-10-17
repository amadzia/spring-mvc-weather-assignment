
package com.example.api.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDataList {

    public Integer dt;
    public Main main;
    public List<Weather> weather = new ArrayList<Weather>();
    public Clouds clouds;
    public Wind wind;
    public Sys sys;
    public String dtTxt;
    public Rain rain;
    public Snow snow;
}
