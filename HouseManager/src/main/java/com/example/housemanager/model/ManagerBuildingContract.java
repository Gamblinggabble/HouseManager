package com.example.housemanager.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@IdClass(ContractId.class)
@Table(name = "CONTRACT")
public class ManagerBuildingContract {

    @Id
    @OneToOne
    private Building building;

    @Id
    @ManyToOne
    private Manager manager;

    private BigDecimal pricePerSqrtM;

    private BigDecimal pricePerPerson;

    private BigDecimal petFee;

    public ManagerBuildingContract() {
    }

    public ManagerBuildingContract(Building building, Manager manager, BigDecimal pricePerSqrtM, BigDecimal pricePerPerson, BigDecimal petFee) {
        this.building = building;
        this.manager = manager;
        setPricePerSqrtM(pricePerSqrtM);
        setPricePerPerson(pricePerPerson);
        setPetFee(petFee);
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setPricePerSqrtM(BigDecimal pricePerSqrtM) {
        if(pricePerSqrtM.compareTo(BigDecimal.valueOf(0)) < 0)
            throw new IllegalArgumentException("Price per sqrtM must be positive.");
        this.pricePerSqrtM = pricePerSqrtM;
    }

    public void setPricePerPerson(BigDecimal pricePerPerson) {
        if(pricePerPerson.compareTo(BigDecimal.valueOf(0)) < 0)
            throw new IllegalArgumentException("Price per person must be positive.");
        this.pricePerPerson = pricePerPerson;
    }

    public void setPetFee(BigDecimal petFee) {
        if(petFee.compareTo(BigDecimal.valueOf(0)) < 0)
            throw new IllegalArgumentException("Fee per pet must be positive.");
        this.petFee = petFee;
    }

    public BigDecimal getPricePerSqrtM() {
        return pricePerSqrtM;
    }

    public BigDecimal getPricePerPerson() {
        return pricePerPerson;
    }

    public BigDecimal getPetFee() {
        return petFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerBuildingContract contract = (ManagerBuildingContract) o;
        return building.equals(contract.building) && manager.equals(contract.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(building, manager);
    }
}
