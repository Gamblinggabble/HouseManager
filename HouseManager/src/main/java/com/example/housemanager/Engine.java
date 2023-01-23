package com.example.housemanager;

import com.example.housemanager.model.*;
import com.example.housemanager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Engine implements ApplicationRunner {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private PersonService personService;

    @Override
    public void run(ApplicationArguments args) {
        saveCompanies();
        saveEmployees();
        saveBuildings();
        saveOccupants();
    }

    private void saveCompanies() {
        System.out.println("--- CREATING COMPANIES ---");

        Company company1 = new Company("Luximo");
        companyService.save(company1);

        Company company2 = new Company("HOME2U");
        companyService.save(company2);
    }

    private void saveEmployees() {
        System.out.println("--- CREATING MANAGERS(EMPLOYEES) ---");

        Manager manager1 = new Manager("Maria Ivanova", companyService.getById(1));
        managerService.save(manager1);

        Manager manager2 = new Manager("Ivo Borisov", companyService.getById(1));
        managerService.save(manager2);
    }

    private void saveBuildings() {
        System.out.println("--- CREATING BUILDINGS, APARTMENTS, OWNERS ---");

        // creating building
        Building building1 = new Building(6);

        // adding apartments and their owners
        Apartment apartment1 = new Apartment(1, 100, 60, new Person("Nikolay", 48, "0878977654", true), 1, building1);
        Apartment apartment2 = new Apartment(2, 200, 60, new Person("Gabriela", 22, "0879271225", true), 3, building1);

        building1.addApartment(apartment1);
        building1.addApartment(apartment2);

        // persist building
        this.buildingService.save(building1);

        // preparing contract
        BigDecimal pricePerSqrtM1 =  BigDecimal.valueOf(1000);
        BigDecimal feePerPerson1 =  BigDecimal.valueOf(15);
        BigDecimal feePerPet1 =  BigDecimal.valueOf(10);
        Manager manager = this.managerService.getById(1);
        ManagerBuildingContract contract = new ManagerBuildingContract(buildingService.getById(1), manager,
                pricePerSqrtM1, feePerPerson1, feePerPet1);
        buildingService.getById(1).setContract(contract);
        manager.addContract(contract);

        // persist contract for building to db
        this.managerService.save(manager);
//        this.contractService.save(contract);
    }

    private void saveOccupants() {
        System.out.println("--- CREATING OCCUPANTS ---");
        Person occupant1 = new Person("Petko Petkov", 23, "0884523621", false);
        Person occupant2 = new Person("Viktor Ivanov", 22, "0872345623", true);

        Apartment apartment = this.apartmentService.getById(1);
        apartment.addOccupant(occupant1);
        apartment.addOccupant(occupant2);
        this.apartmentService.save(apartment);
    }
}