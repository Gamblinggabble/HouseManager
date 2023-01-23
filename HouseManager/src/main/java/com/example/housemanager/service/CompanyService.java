package com.example.housemanager.service;

import com.example.housemanager.model.Company;
import com.example.housemanager.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public Company getById(Integer id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (!companyOptional.isPresent()) {
            System.out.println("Company with id " + id + " does not exist in the database.");
            return null;
        }
        return companyOptional.get();
    }

    public void save(Company company) {
        this.companyRepository.saveAndFlush(company);
    }

    public void deleteById(Integer id) {
        this.companyRepository.deleteById(id);
    }
}
