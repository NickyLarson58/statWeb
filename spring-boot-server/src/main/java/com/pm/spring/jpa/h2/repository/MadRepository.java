package com.pm.spring.jpa.h2.repository;

import com.pm.spring.jpa.h2.model.Mad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MadRepository extends JpaRepository<Mad, Long> {
}