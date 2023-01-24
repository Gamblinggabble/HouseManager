package com.example.housemanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Month;
import java.util.Objects;

@Entity
@IdClass(BillId.class)
public class Bill {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Apartment apartment;
    @Id
    private Month month_of_bill;
    @Id
    private Integer year_of_bill;

    public Bill() {
    }

    public Bill(Apartment apartment, Month month_of_bill, Integer year_of_bill) {
        this.apartment = apartment;
        this.month_of_bill = month_of_bill;
        this.year_of_bill = year_of_bill;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public Month getMonth_of_bill() {
        return month_of_bill;
    }

    public Integer getYear_of_bill() {
        return year_of_bill;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "apartment=" + apartment.getBuildingId() + "-" + apartment.getApartmentNumber() +
                ", month_of_bill=" + month_of_bill +
                ", year_of_bill=" + year_of_bill +
                '}';
    }
}
