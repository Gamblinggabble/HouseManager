package com.example.housemanager.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private int age;

    private String phoneNumber;

    private boolean usesElevator;

    @ManyToMany(mappedBy = "occupants")
    private Set<Apartment> apartmentsInWhichLives;

    @OneToMany(mappedBy="owner")
    private Set<Apartment> apartmentsOwned;

}
