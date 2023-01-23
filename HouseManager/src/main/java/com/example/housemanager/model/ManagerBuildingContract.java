package com.example.housemanager.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@IdClass(ContractId.class)
@Table(name = "manager-building-contract")
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
        this.pricePerSqrtM = pricePerSqrtM;
        this.pricePerPerson = pricePerPerson;
        this.petFee = petFee;
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

    public BigDecimal getPricePerSqrtM() {
        return pricePerSqrtM;
    }

    public BigDecimal getPricePerPerson() {
        return pricePerPerson;
    }

    public BigDecimal getPetFee() {
        return petFee;
    }
}
