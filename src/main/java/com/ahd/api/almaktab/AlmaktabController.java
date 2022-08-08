package com.ahd.api.almaktab;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AlmaktabController {

    @Autowired
    private AlmaktabService almaktabService;

    @GetMapping("/almaktab")
    public List<AlmaktabModel> getListAlmaktab(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return almaktabService.getListAlmaktab(pageNo,pageSize,sortBy);
    }

    @GetMapping("/almaktab/{id}")
    public AlmaktabModel getAlmaktab(@PathVariable int id) {
        return almaktabService.getAlmaktab(id);
    }

    @GetMapping("/almaktab/search/{name}")
    public AlmaktabModel findByName(@PathVariable String name) {
        return almaktabService.findByName(name);
    }

    @PostMapping("/almaktab")
    public AlmaktabModel addAlmaktab(@RequestBody  AlmaktabModel almaktab) {
        return almaktabService.addAlmaktab(almaktab);
    }

    @PutMapping("/almaktab")
    public AlmaktabModel updateAlmaktab(@RequestBody AlmaktabModel almaktab) {
        return almaktabService.updateAlmaktab(almaktab);
    }





}
