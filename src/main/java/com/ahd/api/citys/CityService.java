package com.ahd.api.citys;


import com.ahd.api.exception.BadRequest;
import com.ahd.api.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public CityModel getCity(int id) {
        try {
            return cityRepository.findById(id).get();
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", id));
        }

    }

    public List<CityModel> getListCity() {
        return cityRepository.findAll();
    }

    public CityModel addCity(CityModel city) {
        return cityRepository.save(city);
    }

    public CityModel updateCity(CityModel city) {
        try {
            return cityRepository.save(city);
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", city.getId()));
        }
    }

    public CityModel deleteCity(int id) {
        try {
            if (cityRepository.existsById(id)) {
                CityModel cityModel= cityRepository.findById(id).get();
                cityRepository.deleteById(id);
                return cityModel;
            }
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this id [%s]", id));
        } catch (HttpClientErrorException.BadRequest exception) {
            throw new BadRequest("illegal request");
        }
        throw new NotFoundException(String.format("Not Found this id [%s]", id));
    }

    // search city by name
    public CityModel findByName(String name) {
        try {
            Optional<CityModel> credentials = cityRepository.findByName(name);
            return credentials.get();
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(String.format("Not Found this name [%s]", name));
        }
    }

}
