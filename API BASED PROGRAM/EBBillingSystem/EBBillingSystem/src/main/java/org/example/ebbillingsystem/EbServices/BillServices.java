package org.example.ebbillingsystem.EbServices;

import org.example.ebbillingsystem.BillingRepository.BillingRepo;
import org.example.ebbillingsystem.Models.Billing;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServices {

    private final BillingRepo repo;

    public BillServices(BillingRepo repo) {
        this.repo = repo;
    }

    // Get one bill
    public Billing getBill(int id) {
        return repo.findById(id).orElse(null);
    }

    // Get all bills
    public List<Billing> getAllBills() {
        return repo.findAll();
    }

    // Create bill
    public Billing addBill(Billing bill) {
        return repo.save(bill);
    }

    // Update bill
    public Billing updateBill(Billing bill) {
        if (!repo.existsById(bill.getBillNo())) {
            return null;
        }
        return repo.save(bill);
    }

    // Delete bill
    public String deleteBill(int id) {
        if (!repo.existsById(id)) {
            return "Bill not found";
        }
        repo.deleteById(id);
        return "Deleted successfully";
    }

    public List<Billing> getBillsByHomes(int homeNo) {
        return repo.findByHome_HomeNo(homeNo);
    }

    public List<Billing> getUnpaidBills() {
        return repo.findByPaidFalse();
    }

}