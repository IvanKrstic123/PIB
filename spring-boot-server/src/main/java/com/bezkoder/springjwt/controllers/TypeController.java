package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Type;
import com.bezkoder.springjwt.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.HashSet;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    @PostMapping("/type/add")
    public ResponseEntity<?> addType(@Valid @RequestBody Type type){
        Type type2 = new Type();
        type2.setId(type.getId());
        type2.setTitle(type.getTitle());
        type2.setPerformances(new HashSet<>());

        typeRepository.save(type2);

        return ResponseEntity.ok(type);
    }

    @GetMapping("/type/get")
    public List<Type> get(@Valid @RequestBody String type){
        return typeRepository.findAllByType(type);
    }
}
