package com.example.housemanager.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne()
    private Company company;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "manager", cascade = CascadeType.ALL)
    private Set<ManagerBuildingContract> contracts = new HashSet<>();

    public Manager() {
    }

    public Manager(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public void addContract(ManagerBuildingContract contract) {
        this.contracts.add(contract);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Set<ManagerBuildingContract> getContracts() {
        return contracts;
    }
}
