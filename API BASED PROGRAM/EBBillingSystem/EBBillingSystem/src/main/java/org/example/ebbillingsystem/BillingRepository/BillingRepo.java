package org.example.ebbillingsystem.BillingRepository;

import org.example.ebbillingsystem.Models.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepo extends JpaRepository<Billing, Integer> {

    List<Billing> findByHome_HomeNo(int homeNo);
    List<Billing> findByPaidFalse();
}