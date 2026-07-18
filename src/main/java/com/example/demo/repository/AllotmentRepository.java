package com.example.demo.repository;

import com.example.demo.model.Allotment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllotmentRepository extends JpaRepository<Allotment, Long> {
}