package com.pm.spring.jpa.h2.controller;

import com.pm.spring.jpa.h2.model.Infraction;
import com.pm.spring.jpa.h2.repository.InfractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InfractionController {

    @Autowired
    InfractionRepository infractionRepository;

    @GetMapping("/infractions")
    public ResponseEntity<List<Infraction>> getAllInfractions(@RequestParam(required = false) String libelle) {
        try {
            List<Infraction> infractions = new ArrayList<Infraction>();

            infractionRepository.findAll().forEach(infractions::add);

            if (infractions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(infractions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/infractions/{id}")
    public ResponseEntity<Infraction> getInfractionById(@PathVariable("id") long id) {
        Optional<Infraction> infractionData = infractionRepository.findById(id);

        if (infractionData.isPresent()) {
            return new ResponseEntity<>(infractionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/infractions")
    public ResponseEntity<Infraction> createInfraction(@RequestBody Infraction infraction) {
        try {
            Infraction _infraction = infractionRepository.save(new Infraction(infraction.getNatinf(), infraction.getLibelle()));
            return new ResponseEntity<>(_infraction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/infractions/{id}")
    public ResponseEntity<Infraction> updateInfraction(@PathVariable("id") long id, @RequestBody Infraction infraction) {
        Optional<Infraction> infractionData = infractionRepository.findById(id);

        if (infractionData.isPresent()) {
            Infraction _infraction = infractionData.get();
            _infraction.setNatinf(infraction.getNatinf());
            _infraction.setLibelle(infraction.getLibelle());
            return new ResponseEntity<>(infractionRepository.save(_infraction), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/infractions/{id}")
    public ResponseEntity<HttpStatus> deleteInfraction(@PathVariable("id") long id) {
        try {
            infractionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/infractions")
    public ResponseEntity<HttpStatus> deleteAllInfractions() {
        try {
            infractionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}