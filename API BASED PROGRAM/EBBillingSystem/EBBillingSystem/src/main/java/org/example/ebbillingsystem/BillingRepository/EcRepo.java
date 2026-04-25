package org.example.ebbillingsystem.BillingRepository;

import org.example.ebbillingsystem.Models.ElectricityCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EcRepo extends JpaRepository<ElectricityCenter, Integer> {
}