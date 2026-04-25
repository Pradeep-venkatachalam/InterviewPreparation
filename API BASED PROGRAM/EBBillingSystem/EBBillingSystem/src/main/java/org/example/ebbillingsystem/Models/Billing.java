package org.example.ebbillingsystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer billNo;

    @NotNull(message = "amount is required")
    private Double amount;

    @NotBlank(message = "month is required")
    private String month;


    @ManyToOne
    @JoinColumn(name = "home_id")
    @JsonIgnoreProperties("bills")
    private Home home;

    //prevent deep nesting
    @ManyToOne
    @JoinColumn(name = "ec_id")
    @JsonIgnoreProperties("homes")
    private ElectricityCenter electricityCenter;

    // default false
    @Column(nullable = false)
    private boolean paid = false;

    // ================= GETTERS & SETTERS =================

    public Integer getBillNo() {
        return billNo;
    }

    public void setBillNo(Integer billNo) {
        this.billNo = billNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public ElectricityCenter getElectricityCenter() {
        return electricityCenter;
    }

    public void setElectricityCenter(ElectricityCenter electricityCenter) {
        this.electricityCenter = electricityCenter;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}