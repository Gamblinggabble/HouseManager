package com.example.housemanager.service;

import com.example.housemanager.model.Apartment;
import com.example.housemanager.model.ApartmentId;
import com.example.housemanager.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    public List<Apartment> getAll() {
        return this.apartmentRepository.findAll();
    }

    public Apartment getById(ApartmentId id) {
        Optional<Apartment> apartmentOptional = this.apartmentRepository.findById(id);
        if (!apartmentOptional.isPresent()) {
            System.out.println("Apartment with id " + id + "does not exist in the database.");
            return null;
        }
        return apartmentOptional.get();
    }

    public void save(Apartment apartment) {
        this.apartmentRepository.saveAndFlush(apartment);
    }

    public void deleteById(ApartmentId id) {
        this.apartmentRepository.deleteById(id);
    }
}
