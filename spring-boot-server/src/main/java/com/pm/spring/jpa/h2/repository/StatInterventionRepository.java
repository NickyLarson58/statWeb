package com.pm.spring.jpa.h2.repository;

import com.pm.spring.jpa.h2.model.StatIntervention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatInterventionRepository extends JpaRepository<StatIntervention, Long> {
}