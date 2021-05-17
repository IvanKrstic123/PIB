package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Writer;
import com.bezkoder.springjwt.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class WriterController {

    @Autowired
    private WriterRepository writerRepository;

    @PostMapping("/writer/add")
    public ResponseEntity<?> addWriter(@Valid @RequestBody List<Writer> writers){

        for (Writer writer : writers) {
            Writer writer1 = new Writer();
            writer1.setId(writer.getId());
            writer1.setName(writer.getName());
            writer1.setSurname(writer.getSurname());
            writer1.setBirthDate(writer.getBirthDate());
            writer1.setPerformances(writer.getPerformances());

            writerRepository.save(writer1);
        }
        return ResponseEntity.ok(writers);
    }

    @GetMapping("/writer/all")
    public ResponseEntity<List<Writer>> getAllWriters(){
        List<Writer> writers =  writerRepository.findAll();
        return new ResponseEntity<>(writers, HttpStatus.OK);
    }
}
