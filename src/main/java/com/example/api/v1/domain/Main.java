
package com.example.api.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Main {

    public Double temp;
    public Double tempMin;
    public Double tempMax;
    public Double pressure;
    public Double seaLevel;
    public Double grndLevel;
    public Integer humidity;
    public Integer tempKf;

}
