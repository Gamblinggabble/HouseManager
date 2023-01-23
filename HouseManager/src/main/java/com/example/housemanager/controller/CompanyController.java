package com.example.housemanager.controller;

import com.example.housemanager.model.Company;
import com.example.housemanager.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/fill")
    public List<Company> createAndGetCompanies() {
        companyService.save(new Company("Home2U"));
        return this.companyService.getAll();
    }

    @GetMapping
    public List<Company> getAll() {
        return this.companyService.getAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable Integer id) {
        return this.companyService.getById(id);
    }

    @PostMapping
    public void save(Company company) {
        this.companyService.save(company);
    }
}
