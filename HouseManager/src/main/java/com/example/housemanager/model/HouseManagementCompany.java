package com.example.housemanager.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class HouseManagementCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "company")
    private Set<HouseManager> houseManagers;

}
