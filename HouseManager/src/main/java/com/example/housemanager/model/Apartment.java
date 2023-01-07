package com.example.housemanager.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int floor;

    private int apartmentNumber;

    private double area;

    @ManyToOne()
    private Person owner;

    private int petsCnt;

    @ManyToMany
    private Set<Person> occupants;

    @ManyToOne
    private Building building;

}
