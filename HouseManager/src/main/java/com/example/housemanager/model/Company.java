package com.example.housemanager.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.PERSIST)
    private Set<Manager> houseManagers = new HashSet<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Manager> getHouseManagers() {
        return houseManagers;
    }

    public void addHouseManager(Manager houseManager) {
        this.houseManagers.add(houseManager);
    }
}
