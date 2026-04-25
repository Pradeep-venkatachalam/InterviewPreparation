package org.example.ebbillingsystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.ArrayList;

@Entity
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int homeNo;

    @NotBlank(message = "Name is required")
    private String ownerName;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Number is required")
    @Min(value = 6000000000L, message = "Invalid phone number")
    private long phone;

    // stop recursion (Billing → Home → Billing loop)
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("home")
    private List<Billing> bills = new ArrayList<>();

    //stop recursion for PastVoltages
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("home")
    private List<PastVoltages> voltages = new ArrayList<>();

    //avoid deep nesting from EC → Homes → EC
    @ManyToOne
    @JoinColumn(name = "ec_id")
    @JsonIgnoreProperties("homes")
    private ElectricityCenter electricityCenter;

    // ================= GETTERS & SETTERS =================

    public int getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(int homeNo) {
        this.homeNo = homeNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public List<Billing> getBills() {
        return bills;
    }

    public void setBills(List<Billing> bills) {
        this.bills = bills;
    }

    public List<PastVoltages> getVoltages() {
        return voltages;
    }

    public void setVoltages(List<PastVoltages> voltages) {
        this.voltages = voltages;
    }

    public ElectricityCenter getElectricityCenter() {
        return electricityCenter;
    }

    public void setElectricityCenter(ElectricityCenter electricityCenter) {
        this.electricityCenter = electricityCenter;
    }
}