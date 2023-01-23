package com.example.housemanager.service;

import com.example.housemanager.model.Manager;
import com.example.housemanager.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public List<Manager> getAll() {
        return this.managerRepository.findAll();
    }

    public Manager getById(Integer id) {
        Optional<Manager> houseManagerOptional = this.managerRepository.findById(id);
        if(!houseManagerOptional.isPresent()){
            System.out.println("House Manager with id " + id + " does not exist in the database");
            return null;
        }
        return houseManagerOptional.get();
    }

    public void save(Manager manager) {
        this.managerRepository.saveAndFlush(manager);
    }

    public void deleteById(Integer id) {
        this.managerRepository.deleteById(id);
    }
}
