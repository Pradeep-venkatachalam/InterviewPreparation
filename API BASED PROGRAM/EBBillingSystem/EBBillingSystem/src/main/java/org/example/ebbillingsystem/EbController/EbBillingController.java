package org.example.ebbillingsystem.EbController;

import org.example.ebbillingsystem.EbServices.BillServices;
import org.example.ebbillingsystem.EbServices.EcServices;
import org.example.ebbillingsystem.EbServices.HomeServices;
import org.example.ebbillingsystem.EbServices.PastVoltageServices;
import org.example.ebbillingsystem.Models.Billing;
import org.example.ebbillingsystem.Models.ElectricityCenter;
import org.example.ebbillingsystem.Models.Home;
import org.example.ebbillingsystem.Models.PastVoltages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EbBillingController {

    private final HomeServices homeService;
    private final BillServices billService;
    private final EcServices ecService;
    private final PastVoltageServices pvsService;

    public EbBillingController(HomeServices homeService,
                               BillServices billService,
                               EcServices ecService,
                               PastVoltageServices pvsService) {
        this.homeService = homeService;
        this.billService = billService;
        this.ecService = ecService;
        this.pvsService = pvsService;
    }

    // ================= HOME =================

    @GetMapping("/home/{id}")
    public Home getHome(@PathVariable int id) {
        return homeService.getHome(id);
    }

    @GetMapping("/home")
    public List<Home> getAllHomes() {
        return homeService.getAllHomes();
    }

    @PostMapping("/home")
    public String addHome(@RequestBody Home home) {
        return homeService.addHome(home);
    }

    @PutMapping("/home")
    public String updateHome(@RequestBody Home home) {
        return homeService.updateHome(home);
    }

    @DeleteMapping("/home/{id}")
    public String deleteHome(@PathVariable int id) {
        return homeService.deleteHome(id);
    }

    @GetMapping("/home/{id}/bills")
    public List<Billing> getBillsByHome(@PathVariable int id) {
        return homeService.getBillsByHome(id);
    }

    // ================= BILL =================

    @GetMapping("/bills/{id}")
    public ResponseEntity<Billing> getBill(@PathVariable int id) {
        return ResponseEntity.ok(billService.getBill(id));
    }

    @GetMapping("/bills")
    public ResponseEntity<List<Billing>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }

    @PostMapping("/bills")
    public ResponseEntity<Billing> addBill(@RequestBody Billing billing) {
        return ResponseEntity.ok(billService.addBill(billing));
    }

    @PutMapping("/bills")
    public ResponseEntity<Billing> updateBill(@RequestBody Billing billing) {
        return ResponseEntity.ok(billService.updateBill(billing));
    }

    @DeleteMapping("/bills/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable int id) {
        return ResponseEntity.ok(billService.deleteBill(id));
    }

    @GetMapping("/bills/home/{homeNo}")
    public ResponseEntity<List<Billing>> getBillsByHomes(@PathVariable int homeNo) {
        return ResponseEntity.ok(billService.getBillsByHomes(homeNo));
    }

    @GetMapping("/bills/unpaid")
    public ResponseEntity<List<Billing>> getUnpaidBills() {
        return ResponseEntity.ok(billService.getUnpaidBills());
    }

    // ================= ELECTRICITY CENTER =================

    @GetMapping("/ec/{id}")
    public ElectricityCenter getEc(@PathVariable int id) {
        return ecService.getEc(id);
    }

    @GetMapping("/ec")
    public List<ElectricityCenter> getAllEc() {
        return ecService.getAllEc();
    }

    @PostMapping("/ec")
    public String addEc(@RequestBody ElectricityCenter ec) {
        return ecService.addEc(ec);
    }

    @PutMapping("/ec")
    public String updateEc(@RequestBody ElectricityCenter ec) {
        return ecService.updateEc(ec);
    }

    @DeleteMapping("/ec/{id}")
    public String deleteEc(@PathVariable int id) {
        return ecService.deleteEc(id);
    }

    @GetMapping("/ec/{id}/homes")
    public List<Home> getHomesByEc(@PathVariable int id) {
        return ecService.getHomesByEc(id);
    }

    // ================= PAST VOLTAGES =================
    // IMPORTANT: separated base path to avoid conflict

    @GetMapping("/pvs/{id}")
    public ResponseEntity<?> showPvs(@PathVariable int id) {
        try {
            return ResponseEntity.ok(pvsService.getPvs(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/pvs")
    public ResponseEntity<List<PastVoltages>> getAllPvs() {
        return ResponseEntity.ok(pvsService.getAllPvs());
    }

    @PostMapping("/pvs")
    public ResponseEntity<PastVoltages> addPvs(@RequestBody PastVoltages pv) {
        return ResponseEntity.ok(pvsService.addPvs(pv));
    }

    @PutMapping("/pvs")
    public ResponseEntity<?> updatePvs(@RequestBody PastVoltages pv) {
        try {
            return ResponseEntity.ok(pvsService.updatePvs(pv));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/pvs/{id}")
    public ResponseEntity<?> deletePvs(@PathVariable int id) {
        try {
            pvsService.deletePvs(id);
            return ResponseEntity.ok("Deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}