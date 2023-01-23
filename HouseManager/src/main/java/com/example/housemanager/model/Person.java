package com.example.housemanager.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
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

    @ManyToMany
    @JoinTable(name = "occupant_apartment",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "apartment_id"))
    private Set<Apartment> apartmentsInWhichLives = new HashSet<>();

    @OneToMany(mappedBy="owner", cascade = CascadeType.PERSIST)
    private Set<Apartment> apartmentsOwned = new HashSet<>();

    public Person() {
    }

    public Person(String name, int age, String phoneNumber, boolean usesElevator) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.usesElevator = usesElevator;
    }

    public void addApartmentInWhichLives(Apartment apartment) {
        this.apartmentsInWhichLives.add(apartment);
    }

    public void addApartmentOwned(Apartment apartment) {
        this.apartmentsOwned.add(apartment);
    }
}
