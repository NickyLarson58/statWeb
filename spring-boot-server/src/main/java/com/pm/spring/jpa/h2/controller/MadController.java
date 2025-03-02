package com.pm.spring.jpa.h2.controller;

import com.pm.spring.jpa.h2.model.Mad;
import com.pm.spring.jpa.h2.repository.MadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MadController {

    @Autowired
    MadRepository madRepository;

    @GetMapping("/mad")
    public ResponseEntity<List<Mad>> getAllMads(@RequestParam(required = false) String libelle) {
        try {
            List<Mad> mads = new ArrayList<Mad>();

            madRepository.findAll().forEach(mads::add);

            if (mads.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(mads, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/mad/{id}")
    public ResponseEntity<Mad> getMadById(@PathVariable("id") long id) {
        Optional<Mad> madData = madRepository.findById(id);

        if (madData.isPresent()) {
            return new ResponseEntity<>(madData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/mad")
    public ResponseEntity<Mad> createMad(@RequestBody Mad mad) {
        try {
            Mad _mad = madRepository.save(new Mad(mad.getNatinf(), mad.getLibelle()));
            return new ResponseEntity<>(_mad, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/mad/{id}")
    public ResponseEntity<Mad> updateMad(@PathVariable("id") long id, @RequestBody Mad mad) {
        Optional<Mad> madData = madRepository.findById(id);

        if (madData.isPresent()) {
            Mad _mad = madData.get();
            _mad.setNatinf(mad.getNatinf());
            _mad.setLibelle(mad.getLibelle());
            return new ResponseEntity<>(madRepository.save(_mad), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/mad/{id}")
    public ResponseEntity<HttpStatus> deleteMad(@PathVariable("id") long id) {
        try {
            madRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/mad")
    public ResponseEntity<HttpStatus> deleteAllMads() {
        try {
            madRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}