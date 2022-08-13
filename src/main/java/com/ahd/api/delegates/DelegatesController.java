package com.ahd.api.delegates;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DelegatesController {
    @Autowired
    private DelegatesService delegatesService;

    @GetMapping("/delegates")
    public ResponseEntity getListDelegates(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity(delegatesService.getListDelegates(pageNo,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/delegates/{id}")
    public ResponseEntity getDelegates(@PathVariable int id) {
        return new ResponseEntity<>(delegatesService.getDelegates(id),HttpStatus.OK);
    }

    @GetMapping("/delegates/search/{name}")
    public ResponseEntity findByName(@PathVariable String name) {
        return new ResponseEntity<>(delegatesService.findByName(name),HttpStatus.OK);
    }

    @PostMapping("/delegates")
    public ResponseEntity addDelegates(@RequestBody  DelegatesModel delegates) {
        return new ResponseEntity<>(delegatesService.addDelegates(delegates),HttpStatus.OK);
    }

    @PutMapping("/delegates")
    public ResponseEntity updateDelegates(@RequestBody DelegatesModel delegates) {
        return new ResponseEntity<>(delegatesService.updateDelegates(delegates),HttpStatus.CREATED);
    }

    @DeleteMapping("/delegates/delete/{id}")
    public ResponseEntity deleteDelegates(@PathVariable int id) {
        return new ResponseEntity<>(delegatesService.deleteDelegates(id),HttpStatus.OK);
    }




}
