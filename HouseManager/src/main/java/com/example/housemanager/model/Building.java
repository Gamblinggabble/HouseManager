package com.example.housemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(mappedBy = "building", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Apartment> apartments = new ArrayList<>();

    private int floorsCnt;

    @OneToOne(mappedBy = "building", cascade = CascadeType.ALL)
    @JsonIgnore
    private ManagerBuildingContract contract = null;

    public Building() {

    }

    public Building(int floorsCnt) {
        setFloorsCnt(floorsCnt);
    }

    public Integer getId() {
        return id;
    }

    public List<Apartment> getApartments() {
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

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", floorsCnt=" + floorsCnt +
                ", contract=" + contract +
                '}';
    }
}
