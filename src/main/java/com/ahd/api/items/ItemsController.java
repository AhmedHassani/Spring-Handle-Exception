package com.ahd.api.items;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;


    @RequestMapping("/items")
    public List<ItemsModel> getListItems(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        return itemsService.getListItems(pageNo,pageSize,sortBy);
    }

    @RequestMapping("/items/{id}")
    public ItemsModel getItems(@PathVariable int id) {
        return itemsService.getItems(id);
    }

    @RequestMapping("/items/search/{name}")
    public ItemsModel findByName(@PathVariable String name) {
        return itemsService.findByName(name);
    }

    @RequestMapping("/items")
    public ItemsModel addItems(@RequestBody ItemsModel items) {
        return itemsService.addItems(items);
    }

    @RequestMapping("/items")
    public ItemsModel updateItems(@RequestBody ItemsModel items) {
        return itemsService.updateItems(items);
    }

    @RequestMapping("/items/delete/{id}")
    public void deleteItems(@PathVariable int id) {
        itemsService.deleteItems(id);
    }


}
