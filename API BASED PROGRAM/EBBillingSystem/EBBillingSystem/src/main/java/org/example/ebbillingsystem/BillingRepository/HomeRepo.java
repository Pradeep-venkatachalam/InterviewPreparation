package org.example.ebbillingsystem.BillingRepository;

import org.example.ebbillingsystem.Models.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepo extends JpaRepository<Home, Integer> {
}