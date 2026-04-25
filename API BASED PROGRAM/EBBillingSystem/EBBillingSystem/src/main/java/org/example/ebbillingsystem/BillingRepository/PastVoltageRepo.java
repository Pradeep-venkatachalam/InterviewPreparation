package org.example.ebbillingsystem.BillingRepository;

import org.example.ebbillingsystem.Models.PastVoltages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastVoltageRepo extends JpaRepository<PastVoltages, Integer> {
}