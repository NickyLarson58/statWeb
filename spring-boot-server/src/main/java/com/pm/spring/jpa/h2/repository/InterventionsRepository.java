package com.pm.spring.jpa.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pm.spring.jpa.h2.model.Interventions;

@Repository
public interface InterventionsRepository extends JpaRepository<Interventions, Integer> {
}