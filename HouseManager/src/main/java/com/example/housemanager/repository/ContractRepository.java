package com.example.housemanager.repository;

import com.example.housemanager.model.ContractId;
import com.example.housemanager.model.ManagerBuildingContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ManagerBuildingContract, ContractId> {
}
