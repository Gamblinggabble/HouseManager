package com.example.housemanager.service;

import com.example.housemanager.model.ContractId;
import com.example.housemanager.model.ManagerBuildingContract;
import com.example.housemanager.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public List<ManagerBuildingContract> getAll() {
        return this.contractRepository.findAll();
    }

    public ManagerBuildingContract getById(ContractId id) {
        Optional<ManagerBuildingContract> contractOptional = this.contractRepository.findById(id);
        if(!contractOptional.isPresent()) {
            System.out.println("Contract by manager " + id.getManager() + " for building " + id.getBuilding() + " does not exist in database");
            return null;
        }
        return contractOptional.get();
    }

    public void save(ManagerBuildingContract contract) {
        this.contractRepository.saveAndFlush(contract);
    }

    public void deleteById(ContractId id) {
        this.contractRepository.deleteById(id);
    }

}
