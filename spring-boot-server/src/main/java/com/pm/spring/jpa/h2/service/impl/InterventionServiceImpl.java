package com.pm.spring.jpa.h2.service.impl;

import com.pm.spring.jpa.h2.model.Interventions;
import com.pm.spring.jpa.h2.payload.CreatedStatInterventionDTO;
import com.pm.spring.jpa.h2.repository.InterventionsRepository;
import com.pm.spring.jpa.h2.service.InterventionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InterventionServiceImpl implements InterventionService {

    @Autowired
    private InterventionsRepository interventionsRepository;

    @Override
    @Transactional
    public Long createIntervention(CreatedStatInterventionDTO interventionDTO) {
        return null;
    }
}