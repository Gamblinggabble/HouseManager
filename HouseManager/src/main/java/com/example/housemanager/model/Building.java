package com.example.housemanager.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "building", cascade = CascadeType.PERSIST)
    private Set<Apartment> apartments = new HashSet<>();

    private int floorsCnt;

    @OneToOne(mappedBy = "building", cascade = CascadeType.ALL)
    private ManagerBuildingContract contract = null;

    public Building() {

    }

    public Building(int floorsCnt) {
        setFloorsCnt(floorsCnt);
    }

    public Integer getId() {
        return id;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }

    public ManagerBuildingContract getContract() {
        return contract;
    }

    public int getFloorsCnt() {
        return floorsCnt;
    }

    public void setFloorsCnt(int floorsCnt) {
        if (floorsCnt <= 0)
            throw new IllegalArgumentException("Floors count must be a positive number");

        this.floorsCnt = floorsCnt;
    }

    public void setContract(ManagerBuildingContract contract) {
        this.contract = contract;
    }

    public void addApartment(Apartment apartment) {
        this.apartments.add(apartment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return id.equals(building.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
