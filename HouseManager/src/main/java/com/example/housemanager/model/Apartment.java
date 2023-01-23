package com.example.housemanager.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int floor;

    private int apartmentNumber;

    private double area;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Person owner;

    private int petsCnt;

    @ManyToMany(mappedBy = "apartmentsInWhichLives", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Person> occupants = new HashSet<>();

    @ManyToOne
    private Building building;

    public Apartment() {
    }

    public Apartment(int floor, int apartmentNumber, double area, Person owner, int petsCnt, Building building) {
        this.floor = floor;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.owner = owner;
        this.petsCnt = petsCnt;
        this.building = building;
    }

    public void setFloor(int floor) {
        if (floor < 0 || floor > this.building.getFloorsCnt())
            throw new IllegalArgumentException("Floor number must be a valid number between 0 and " + this.building.getFloorsCnt());
        this.floor = floor;
    }

    public void addOccupant(Person person) {
        this.occupants.add(person);
        person.addApartmentInWhichLives(this);
    }
}
