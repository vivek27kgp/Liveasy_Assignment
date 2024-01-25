package com.assignment.liveasy_assign.controller;

import com.assignment.liveasy_assign.entities.Load;
import com.assignment.liveasy_assign.services.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class LoadController {
    @Autowired
    private LoadService loadService;

    @PostMapping("/load")
    public String addLoad(@RequestBody Load load) {
        return loadService.addLoad(load);
    }

    @GetMapping("/load")
    public List<Load> getLoadsByShipperId(@RequestParam String shipperId) {
        return loadService.getLoadsByShipperId(shipperId);
    }

    @GetMapping("/load/{loadId}")
    public Load getLoadById(@PathVariable int loadId) {
        return loadService.getLoadById(loadId);
    }

    @PutMapping("/load/{loadId}")
    public String updateLoad(@PathVariable int loadId, @RequestBody Load updatedLoad){
        return loadService.updateLoad(loadId, updatedLoad);
    }

    @DeleteMapping("/load/{loadId}")
    public String deleteLoad(@PathVariable int loadId) {
        return loadService.deleteLoad(loadId);
    }
}
