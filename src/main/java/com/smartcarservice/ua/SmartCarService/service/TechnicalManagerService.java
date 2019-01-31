package com.smartcarservice.ua.SmartCarService.service;

import com.smartcarservice.ua.SmartCarService.entity.sto.TechnicalManager;

public interface TechnicalManagerService {
    public abstract void createTechnicalManager(TechnicalManager technicalManager);
    public abstract void updateTechnicalManager(Long id, TechnicalManager technicalManager);
    public abstract void deleteTechnicalManager(Long id);
    public abstract TechnicalManager getTechnicalManager(Long id);
}