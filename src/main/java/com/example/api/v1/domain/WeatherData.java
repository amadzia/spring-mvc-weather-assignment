
package com.example.api.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {

    public String cod;
    public Double message;
    public Integer cnt;
    public List<WeatherDataList> list = new ArrayList<>();
    public City city;

}
