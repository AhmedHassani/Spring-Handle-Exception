package com.ahd.api.citys;


import javax.persistence.*;

@Entity
@Table(name = "citys")
public class CityModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "census")
    private int census;
    @Column(name = "city_code")
    private int city_code;

    public CityModel(String name, int census, int city_code) {
        this.name = name;
        this.census = census;
        this.city_code = city_code;
    }

    public CityModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCensus() {
        return census;
    }

    public void setCensus(int census) {
        this.census = census;
    }

    public int getCity_code() {
        return city_code;
    }

    public void setCity_code(int city_code) {
        this.city_code = city_code;
    }


}
