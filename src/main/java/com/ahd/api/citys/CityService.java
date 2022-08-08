package com.ahd.api.citys;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public CityModel getCity(int id) {
        return cityRepository.findById(id).get();
    }

    public List<CityModel> getListCity() {
        return cityRepository.findAll();
    }

    public CityModel addCity(CityModel city) {
        return cityRepository.save(city);
    }

    public CityModel updateCity(CityModel city) {
        return cityRepository.save(city);
    }

    public void deleteCity(int id) {
        cityRepository.deleteById(id);
    }

    // search city by name
    public CityModel findByName(String name) {
        Optional<CityModel> credentials = cityRepository.findByName(name);
        return credentials.get();

    }

}
