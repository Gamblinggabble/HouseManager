package com.example.housemanager.service;

import com.example.housemanager.model.Apartment;
import com.example.housemanager.model.Building;
import com.example.housemanager.repository.BuildingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public List<Building> getAll() {
        return this.buildingRepository.findAll();
    }

    public Building getById(Integer id) {
        Optional<Building> buildingOptional = this.buildingRepository.findById(id);
        if (!buildingOptional.isPresent()) {
            System.out.println("Building with id " + id + " does not exist in the database.");
            return null;
        }
        return buildingOptional.get();
    }

    public void save(Building building) {
        this.buildingRepository.saveAndFlush(building);
    }

    public void deleteById(Integer id) {
        this.buildingRepository.deleteById(id);
    }

    public Collection<Apartment> getApartments(Integer buildingId) {
        if(this.getById(buildingId) != null) {
            return this.getById(buildingId).getApartments();
        }
        else {
            throw new EntityNotFoundException("Building with id " + buildingId + " does not exist in db!");
        }
    }
}
