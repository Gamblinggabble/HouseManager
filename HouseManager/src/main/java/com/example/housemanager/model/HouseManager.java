package com.example.housemanager.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class HouseManager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    private HouseManagementCompany company;

    @OneToMany(mappedBy = "manager")
    private Set<ManagerBuildingContract> contracts;
}
