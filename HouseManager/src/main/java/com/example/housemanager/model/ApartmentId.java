package com.example.housemanager.model;

import java.io.Serializable;
import java.util.Objects;

public class ApartmentId implements Serializable {

    private String apartmentNumber;
    private Building building;

    public ApartmentId() {
    }

    public ApartmentId(String apartmentNumber, Building building) {
        this.apartmentNumber = apartmentNumber;
        this.building = building;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public Building getBuilding() {
        return building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentId that = (ApartmentId) o;
        return apartmentNumber.equals(that.apartmentNumber) && building.equals(that.building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apartmentNumber, building);
    }
}
