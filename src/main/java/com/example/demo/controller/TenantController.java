package com.example.demo.controller;

import com.example.demo.model.Tenant;
import com.example.demo.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tenants")
@CrossOrigin(origins = "http://localhost:4200")
public class TenantController { // Khel yahan tha, ab ekdum sahi hai!

    @Autowired
    private TenantRepository tenantRepository;

    @GetMapping
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    @PostMapping
    public Tenant registerTenant(@RequestBody Tenant tenant) {
        try {
            if (tenant.getJoiningDate() == null) {
                tenant.setJoiningDate(LocalDate.now());
            }
            if (tenant.getRegistrationMeterReading() == null) {
                tenant.setRegistrationMeterReading(0.0);
            }
            
            tenant.setIdProofNumber("TEMP123");
            tenant.setPermanentAddress("India");

            return tenantRepository.save(tenant);
        } catch (Exception e) {
            System.out.println("CRITICAL ERROR DURING TENANT REGISTRATION: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Tenant storage operation collapsed internally.");
        }
    }
}