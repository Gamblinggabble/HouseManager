package com.example.housemanager.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class ManagerBuildingContract {

    @Id
    @OneToOne
    private Building building;

    @Id
    @ManyToOne
    private HouseManager manager;

    private BigDecimal pricePerSqrtM;

    private BigDecimal pricePerPerson;

    private BigDecimal petFee;

}
