package com.ahd.api.citys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/v1")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/citys")
    public List<CityModel> getListCity() {
        return cityService.getListCity();
    }

    @GetMapping("/citys/{id}")
    public CityModel getCity(@PathVariable int id) {
        return cityService.getCity(id);
    }

    @PostMapping("/citys")
    public CityModel addCity(@RequestBody CityModel city) {
        return cityService.addCity(city);
    }

    @PutMapping("/citys")
    public CityModel updateCity(@RequestBody CityModel city) {
        return cityService.updateCity(city);
    }

    @DeleteMapping("/citys/{id}")
    public void deleteCity(@PathVariable int id) {
        cityService.deleteCity(id);
    }

    @GetMapping("/citys/search/{name}")
    public CityModel findByName(@PathVariable String name) {
        return cityService.findByName(name);
    }



}
