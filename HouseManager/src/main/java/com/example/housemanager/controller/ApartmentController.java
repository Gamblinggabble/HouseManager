package com.example.housemanager.controller;

import com.example.housemanager.model.Apartment;
import com.example.housemanager.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apartments")
public class ApartmentController {

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    public List<Apartment> getAll() {
        return apartmentService.getAll();
    }

    @GetMapping("/get")
    public Apartment getById(@RequestParam(required = true, name = "building_id") Integer building_id,
                                   @RequestParam(required = true, name = "apartment_number") String apartment_number) {

        return apartmentService.getById(building_id, apartment_number);
    }
}
