package com.example.housemanager.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "building")
    private Set<Apartment> apartments;

//    private BuildingContract contract;

}
