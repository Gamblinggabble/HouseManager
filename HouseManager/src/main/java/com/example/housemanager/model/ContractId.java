package com.example.housemanager.model;

import java.io.Serializable;
import java.util.Objects;

public class ContractId implements Serializable {

    private Building building;
    private Manager manager;

    public ContractId() {
    }

    public ContractId(Building building, Manager manager) {
        this.building = building;
        this.manager = manager;
    }

    public Building getBuilding() {
        return building;
    }

    public Manager getManager() {
        return manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractId that = (ContractId) o;
        return building.equals(that.building) && manager.equals(that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, manager);
    }
}
