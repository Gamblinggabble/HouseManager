package com.example.housemanager.model;

import java.io.Serializable;
import java.time.Month;
import java.util.Objects;

public class BillId implements Serializable {

    private Apartment apartment;
    private Month month_of_bill;
    private Integer year_of_bill;

    public BillId() {
    }

    public BillId(Apartment apartment, Month month_of_bill, Integer year_of_bill) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillId billId = (BillId) o;
        return apartment.equals(billId.apartment) && month_of_bill == billId.month_of_bill && year_of_bill.equals(billId.year_of_bill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apartment, month_of_bill, year_of_bill);
    }
}
