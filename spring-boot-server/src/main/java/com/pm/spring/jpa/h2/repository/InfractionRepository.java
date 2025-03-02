package com.pm.spring.jpa.h2.repository;

import com.pm.spring.jpa.h2.model.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfractionRepository extends JpaRepository<Infraction, Long> {
}