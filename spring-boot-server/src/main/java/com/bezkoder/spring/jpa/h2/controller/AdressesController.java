package com.bezkoder.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bezkoder.spring.jpa.h2.model.Adresses;
import com.bezkoder.spring.jpa.h2.repository.AdressesRepository;

@CrossOrigin(origins = "http://10.10.6.124:8081")
@RestController
@RequestMapping("/api")
public class AdressesController {

    @Autowired
    AdressesRepository adressesRepository;

    @GetMapping("/adresses")
    public ResponseEntity<List<Adresses>> getAllAdresses() {
        try {
            List<Adresses> adresses = adressesRepository.findAll();
            if (adresses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(adresses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/adresses/{id}")
    public ResponseEntity<Adresses> getAdressesById(@PathVariable("id") long id) {
        Optional<Adresses> adressesData = adressesRepository.findById(id);
        if (adressesData.isPresent()) {
            return new ResponseEntity<>(adressesData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adresses")
    public ResponseEntity<Adresses> createAdresses(@RequestBody Adresses adresses) {
        try {
            Adresses _adresses = adressesRepository.save(adresses);
            return new ResponseEntity<>(_adresses, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/adresses/{id}")
    public ResponseEntity<Adresses> updateAdresses(@PathVariable("id") long id, @RequestBody Adresses adresses) {
        Optional<Adresses> adressesData = adressesRepository.findById(id);
        if (adressesData.isPresent()) {
            Adresses _adresses = adressesData.get();
            _adresses.setNomadresse(adresses.getNomadresse());
            return new ResponseEntity<>(adressesRepository.save(_adresses), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/adresses/{id}")
    public ResponseEntity<HttpStatus> deleteAdresses(@PathVariable("id") long id) {
        try {
            adressesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/adresses")
    public ResponseEntity<HttpStatus> deleteAllAdresses() {
        try {
            adressesRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}