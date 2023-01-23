package com.example.housemanager.repository;

import com.example.housemanager.model.Apartment;
import com.example.housemanager.model.ApartmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, ApartmentId> {
}
