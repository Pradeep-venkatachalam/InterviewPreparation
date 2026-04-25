package org.example.ebbillingsystem.EbServices;

import org.example.ebbillingsystem.BillingRepository.HomeRepo;
import org.example.ebbillingsystem.Models.Billing;
import org.example.ebbillingsystem.Models.Home;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServices {

    private final HomeRepo repo;

    public HomeServices(HomeRepo repo) {
        this.repo = repo;
    }

    public Home getHome(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Home> getAllHomes() {
        return repo.findAll();
    }

    public String addHome(Home home) {
        repo.save(home);
        return "Home added";
    }

    public String updateHome(Home home) {
        if (!repo.existsById(home.getHomeNo())) {
            return "Home not found";
        }
        repo.save(home);
        return "Updated";
    }

    public String deleteHome(int id) {
        if (!repo.existsById(id)) {
            return "Home not found";
        }
        repo.deleteById(id);
        return "Deleted";
    }
    public List<Billing> getBillsByHome(int homeId) {
        return repo.findById(homeId)
                .orElseThrow(() -> new RuntimeException("Home not found"))
                .getBills();
    }
}