package com.pm.spring.jpa.h2.repository;

import com.pm.spring.jpa.h2.model.Missions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionsRepository extends JpaRepository<Missions, Long> {
    List<Missions> findByNomMission(String nomMission);
}