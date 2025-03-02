package com.pm.spring.jpa.h2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pm.spring.jpa.h2.model.Agents;

@Repository
public interface AgentsRepository extends JpaRepository<Agents, Long> {
    Optional<Agents> findByMatricule(int matricule);

    Boolean existsByMatricule(int matricule);

    Optional<Agents> findAgentsByMatriculeAndMdp(int matricule, int mdp);
}