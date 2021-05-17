package com.bezkoder.springjwt.services.implementation;

import com.bezkoder.springjwt.models.Performance;
import com.bezkoder.springjwt.repository.PerformanceRepository;
import com.bezkoder.springjwt.services.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepository;

    @Override
    public Performance savePerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    @Override
    public Page<Performance> getAllPerformance(int pageNumber, int pageSize, Sort.Direction order) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(order, "id"));
        return performanceRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Performance> getById(Long id) {
        return performanceRepository.findById(id);
    }

    @Override
    public Performance updatePerformance(Performance performance) {
        return performanceRepository.save(performance);
    }

    @Override
    public void deletePerformance(Long id) {
        performanceRepository.deleteById(id);
    }
}
