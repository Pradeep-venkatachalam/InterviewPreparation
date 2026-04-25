package org.example.ebbillingsystem.EbServices;

import org.example.ebbillingsystem.BillingRepository.PastVoltageRepo;
import org.example.ebbillingsystem.Models.PastVoltages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PastVoltageServices {

    private final PastVoltageRepo repo;

    public PastVoltageServices(PastVoltageRepo repo) {
        this.repo = repo;
    }

    // GET by ID (safe)
    public PastVoltages getPvs(int id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("PastVoltage not found with id: " + id));
    }

    // GET ALL
    public List<PastVoltages> getAllPvs() {
        return repo.findAll();
    }

    // ADD
    public PastVoltages addPvs(PastVoltages pvs) {
        return repo.save(pvs);
    }

    // UPDATE
    public PastVoltages updatePvs(PastVoltages pvs) {
        if (!repo.existsById(pvs.getId())) {
            throw new RuntimeException("PastVoltage not found with id: " + pvs.getId());
        }
        return repo.save(pvs);
    }

    // DELETE
    public void deletePvs(int id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("PastVoltage not found with id: " + id);
        }
        repo.deleteById(id);
    }
}