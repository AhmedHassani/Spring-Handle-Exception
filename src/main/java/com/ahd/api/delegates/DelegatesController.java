package com.ahd.api.delegates;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DelegatesController {
    @Autowired
    private DelegatesService delegatesService;

    @GetMapping("/delegates")
    public List<DelegatesModel> getListDelegates(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return delegatesService.getListDelegates(pageNo,pageSize,sortBy);
    }

    @GetMapping("/delegates/{id}")
    public DelegatesModel getDelegates(@PathVariable int id) {
        return delegatesService.getDelegates(id);
    }

    @GetMapping("/delegates/search/{name}")
    public DelegatesModel findByName(@PathVariable String name) {
        return delegatesService.findByName(name);
    }

    @PostMapping("/delegates")
    public DelegatesModel addDelegates(@RequestBody  DelegatesModel delegates) {
        return delegatesService.addDelegates(delegates);
    }

    @PutMapping("/delegates")
    public DelegatesModel updateDelegates(@RequestBody DelegatesModel delegates) {
        return delegatesService.updateDelegates(delegates);
    }

    @DeleteMapping("/delegates/delete/{id}")
    public void deleteDelegates(@PathVariable int id) {
        delegatesService.deleteDelegates(id);
    }




}
