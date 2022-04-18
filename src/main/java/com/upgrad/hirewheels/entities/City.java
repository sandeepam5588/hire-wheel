package com.upgrad.hirewheels.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name = "city_id",length = 10, nullable = false)
    private int cityId;

    @Column(name = "city_name",length = 50, nullable = false)
    private String cityName;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Location> locations;

    public City(){}

    public City(int cityId, String cityName, Set<Location> locations) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.locations = locations;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
