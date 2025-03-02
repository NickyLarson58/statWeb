package com.pm.spring.jpa.h2.repository;

import com.pm.spring.jpa.h2.model.InterventionAgents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionAgentsRepository extends JpaRepository<InterventionAgents, Long> {
}