package com.example.demo.controller;

import com.example.demo.model.Allotment;
import com.example.demo.repository.AllotmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/allotments")
@CrossOrigin(origins = "*")
public class AllotmentController {

    @Autowired
    private AllotmentRepository allotmentRepository;

    @GetMapping
    public List<Allotment> getAllAllotments() {
        return allotmentRepository.findAll();
    }

    @PostMapping
    public Allotment createAllotment(@RequestBody Allotment allotment) {
        return allotmentRepository.save(allotment);
    }
}