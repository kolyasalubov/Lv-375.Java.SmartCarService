package com.smartcarservice.ua.SmartCarService.service;

import com.smartcarservice.ua.SmartCarService.dto.stoDto.TechnicalServiceDto;
import com.smartcarservice.ua.SmartCarService.entity.sto.TechnicalService;

import java.util.List;

public interface TechnicalServiceService {
    TechnicalService getTechnicalServiceById(Long id);
    void createTechnicalService(String name, String address);
    List<TechnicalService> getAllTechnicalServices();
}