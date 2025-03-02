package com.pm.spring.jpa.h2.repository;

import com.pm.spring.jpa.h2.model.StatMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatMissionRepository extends JpaRepository<StatMission, Long> {
}