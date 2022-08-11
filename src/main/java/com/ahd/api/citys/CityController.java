package com.ahd.api.citys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/v1")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/citys")
    public ResponseEntity getListCity() {
        return new ResponseEntity(cityService.getListCity(), HttpStatus.OK);
    }

    @GetMapping("/citys/{id}")
    public ResponseEntity getCity(@PathVariable int id) {

        return new ResponseEntity(cityService.getCity(id), HttpStatus.OK);
    }

    @PostMapping("/citys")
    public ResponseEntity addCity(@RequestBody CityModel city) {

        return new ResponseEntity(cityService.addCity(city),HttpStatus.CREATED);
    }

    @PutMapping("/citys")
    public ResponseEntity updateCity(@RequestBody CityModel city) {
        return new ResponseEntity(cityService.updateCity(city),HttpStatus.CREATED);
    }

    @DeleteMapping("/citys/{id}")
    public ResponseEntity deleteCity(@PathVariable int id) {
        return new ResponseEntity(cityService.deleteCity(id),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/citys/search/{name}")
    public ResponseEntity findByName(@PathVariable String name) {
        return new ResponseEntity(cityService.findByName(name), HttpStatus.OK);
    }



}
