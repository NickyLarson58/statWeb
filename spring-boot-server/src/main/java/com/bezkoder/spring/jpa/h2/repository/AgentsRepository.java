package com.bezkoder.spring.jpa.h2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.jpa.h2.model.Agents;

@Repository
public interface AgentsRepository extends JpaRepository<Agents, Long> {
    Optional<Agents> findByMatricule(String matricule);
    Boolean existsByMatricule(String matricule);
}