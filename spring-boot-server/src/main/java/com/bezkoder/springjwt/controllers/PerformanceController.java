package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Performance;
import com.bezkoder.springjwt.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard/performances")
public class PerformanceController {

    @Autowired
    private PerformanceRepository performanceRepository;

    @PostMapping("/add")
    public ResponseEntity<Performance> addEmployee(@RequestBody Performance performance){
        Performance performance2 = performanceRepository.save(performance);
        return new ResponseEntity<>(performance2, HttpStatus.CREATED);
    }
}
