package com.ahd.api.almaktab;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AlmaktabController {

    @Autowired
    private AlmaktabService almaktabService;

    @GetMapping("/almaktab")
    public ResponseEntity getListAlmaktab(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity(almaktabService.getListAlmaktab(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/almaktab/{id}")
    public ResponseEntity getAlmaktab(@PathVariable int id) {
        return new ResponseEntity(almaktabService.getAlmaktab(id),HttpStatus.OK);
    }

    @GetMapping("/almaktab/search/{name}")
    public ResponseEntity findByName(@PathVariable String name) {
        return new ResponseEntity(almaktabService.findByName(name),HttpStatus.OK);
    }

    @PostMapping("/almaktab")
    public ResponseEntity addAlmaktab(@RequestBody  AlmaktabModel almaktab) {
        return new ResponseEntity(almaktabService.addAlmaktab(almaktab),HttpStatus.CREATED);
    }

    @PutMapping("/almaktab")
    public ResponseEntity updateAlmaktab(@RequestBody AlmaktabModel almaktab) {
        return new ResponseEntity(almaktabService.updateAlmaktab(almaktab),HttpStatus.CREATED);
    }

    @DeleteMapping("/almaktab/{id}")
    public ResponseEntity deleteAlmaktab(@PathVariable int id) {
        return new ResponseEntity(almaktabService.deleteAlmaktab(id),HttpStatus.OK);
    }





}
