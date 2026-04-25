package org.example.ebbillingsystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class ElectricityCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // ✅ FIXED
    private Integer ecId;

    @NotBlank(message = "Name is required")
    private String ecName;
    @NotBlank(message = "location is required")
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "electricityCenter", fetch = FetchType.LAZY)
    private List<Home> homes;

    // Getters & Setters

    public int getEcId() {
        return ecId;
    }

    public void setEcId(int ecId) {
        this.ecId = ecId;
    }

    public String getEcName() {
        return ecName;
    }

    public void setEcName(String ecName) {
        this.ecName = ecName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }
}