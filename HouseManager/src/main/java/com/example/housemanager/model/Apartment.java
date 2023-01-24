package com.example.housemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@IdClass(ApartmentId.class)
public class Apartment {

    private int floor;

    @Id
    private String apartmentNumber;

    @ManyToOne
    @Id
    @JsonIgnore
    private Building building;

    private double area_inner;

    private double area_shared;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Person owner;

    private int petsCnt;

    @ManyToMany(mappedBy = "apartmentsInWhichLives", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Person> occupants = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "apartment_apartment_number"),
            @JoinColumn(name = "apartment_building_id"),
    })
    private List<Bill> bills = new ArrayList<>();

    public Apartment() {
    }

    public Apartment(int floor, String apartmentNumber, double area_inner, double area_shared, Person owner, int petsCnt, Building building) {
        this.floor = floor;
        this.apartmentNumber = apartmentNumber;
        this.area_inner = area_inner;
        this.area_shared = area_shared;
        this.owner = owner;
        this.petsCnt = petsCnt;
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public double getInnerArea() {
        return area_inner;
    }

    public double getSharedArea() {
        return area_shared;
    }

    public Person getOwner() {
        return owner;
    }

    public int getPetsCnt() {
        return petsCnt;
    }

    public Set<Person> getOccupants() {
        return occupants;
    }

    public Integer getBuildingId() {
        return this.building.getId();
    }

    public Building getBuilding() {
        return building;
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

    public BigDecimal getFeesForMonth() {
        BigDecimal sum = BigDecimal.valueOf(0);
        sum = sum.add(this.building.getContract().getPricePerPerson().multiply(BigDecimal.valueOf(this.getOccupants().size())));
        sum = sum.add(this.building.getContract().getPricePerSqrtM().multiply(BigDecimal.valueOf(this.getSharedArea())));
        sum = sum.add(this.building.getContract().getPetFee().multiply(BigDecimal.valueOf(this.getPetsCnt())));
        return sum;
    }

    public void payFees() {
        if(bills.isEmpty()) {
            this.bills.add(new Bill(this, LocalDateTime.now().getMonth(), LocalDateTime.now().getYear()));
        } else {
            Month monthPaid = this.bills.get(this.bills.size()-1).getMonth_of_bill();
            for (Month month : Month.values()) {
                if(month.compareTo(monthPaid) > 0) {
                    this.bills.add(new Bill(this, LocalDateTime.now().getMonth(), LocalDateTime.now().getYear()));
                }
            }
        }
    }

    @Override
    public String toString() {
        Integer buildingId = null;
        if(this.building != null) buildingId = this.building.getId();
        return "Apartment{" +
                "floor=" + floor +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", building=" + buildingId +
                ", area_inner=" + area_inner +
                ", area_shared=" + area_shared +
                ", owner=" + owner.getName() +
                ", petsCnt=" + petsCnt +
                ", occupants=" + occupants.size() +
                ", bills=" + bills +
                '}';
    }
}
