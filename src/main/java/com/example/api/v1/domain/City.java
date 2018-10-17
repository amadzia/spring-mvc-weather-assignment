
package com.example.api.v1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    public Integer id;
    public String name;
    public Coord coord;
    public String country;

    public City(String name) {
        this.name = name;
    }
}
