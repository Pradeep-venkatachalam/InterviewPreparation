package org.example.ebbillingsystem.EbServices;

import org.example.ebbillingsystem.BillingRepository.EcRepo;
import org.example.ebbillingsystem.Models.ElectricityCenter;
import org.example.ebbillingsystem.Models.Home;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcServices {

    private final EcRepo ecRepo;

    public EcServices(EcRepo ecRepo) {
        this.ecRepo = ecRepo;
    }

    // ================= EC CRUD =================

    public ElectricityCenter getEc(int id) {
        return ecRepo.findById(id).orElse(null);
    }

    public List<ElectricityCenter> getAllEc() {
        return ecRepo.findAll();
    }

    public String addEc(ElectricityCenter ec) {
        ecRepo.save(ec);
        return "EC added";
    }

    public String updateEc(ElectricityCenter ec) {
        if (!ecRepo.existsById(ec.getEcId())) {
            return "EC not found";
        }
        ecRepo.save(ec);
        return "Updated";
    }

    public String deleteEc(int id) {
        if (!ecRepo.existsById(id)) {
            return "EC not found";
        }
        ecRepo.deleteById(id);
        return "Deleted";
    }

    // ================= RELATION METHOD =================

    public List<Home> getHomesByEc(int ecId) {
        ElectricityCenter ec = ecRepo.findById(ecId)
                .orElseThrow(() -> new RuntimeException("EC not found"));

        return ec.getHomes();
    }
}