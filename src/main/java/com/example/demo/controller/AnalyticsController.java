package com.example.demo.controller;

import com.example.demo.model.Room;
import com.example.demo.model.Payment;
import com.example.demo.repository.RoomRepository;
import com.example.demo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/analytics")
@CrossOrigin(origins = "http://localhost:4200")
public class AnalyticsController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/stats")
    public Map<String, Object> getDashboardStats() {
        List<Room> rooms = roomRepository.findAll();
        List<Payment> payments = paymentRepository.findAll();

        long totalRooms = rooms.size();
        long occupiedRooms = rooms.stream().filter(r -> "OCCUPIED".equalsIgnoreCase(r.getStatus()) || Boolean.FALSE.equals(r.getIsAvailable())).count();

        double totalExpected = payments.stream().mapToDouble(p -> p.getTotalPayable() != null ? p.getTotalPayable() : 0.0).sum();
        double totalCollected = payments.stream().mapToDouble(p -> p.getAmountPaid() != null ? p.getAmountPaid() : 0.0).sum();
        double totalDue = payments.stream().mapToDouble(p -> p.getBalanceDue() != null ? p.getBalanceDue() : 0.0).sum();

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalRooms", totalRooms);
        stats.put("occupiedRooms", occupiedRooms);
        stats.put("totalExpected", totalExpected);
        stats.put("totalCollected", totalCollected);
        stats.put("totalDue", totalDue);

        return stats;
    }
}