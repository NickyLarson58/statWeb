package com.bezkoder.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.jpa.h2.model.Adresses;

@Repository
public interface AdressesRepository extends JpaRepository<Adresses, Long> {
}