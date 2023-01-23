package com.example.housemanager.controller;

import com.example.housemanager.model.Building;
import com.example.housemanager.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public List<Building> getAll() {
        return buildingService.getAll();
    }

    @GetMapping("/{id}")
    public Building getById(@PathVariable Integer id) {
        return buildingService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        buildingService.deleteById(id);
    }
}
