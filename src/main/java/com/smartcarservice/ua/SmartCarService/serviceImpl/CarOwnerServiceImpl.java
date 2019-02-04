package com.smartcarservice.ua.SmartCarService.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.smartcarservice.ua.SmartCarService.dto.stoDto.CarDto;
import com.smartcarservice.ua.SmartCarService.dto.stoDto.CarOwnerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartcarservice.ua.SmartCarService.entity.car.CarOwner;
import com.smartcarservice.ua.SmartCarService.entity.car.Car;
import com.smartcarservice.ua.SmartCarService.repository.CarOwnerRepository;
import com.smartcarservice.ua.SmartCarService.service.CarOwnerService;

@Service
public class CarOwnerServiceImpl implements CarOwnerService {

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    //TODO check if such number & vin is registered
    public void create(CarOwner carOwner) {
        carOwnerRepository.save(carOwner);
    }


    public CarOwnerDto getCarOwnerById(Long id) {
        CarOwner carOwner = carOwnerRepository.getCarOwnerById(id);
        CarOwnerDto carOwnerDto = getCarOwnerDto(carOwner);
        return carOwnerDto;
    }

    public List<CarOwnerDto> findAll() {
        List<CarOwnerDto> carOwnerDtos = new ArrayList<>();
        for (CarOwner carOwner : carOwnerRepository.findAll()) {
            carOwnerDtos.add(getCarOwnerDto(carOwner));
        }
        return carOwnerDtos;
    }

    public CarOwnerDto findByUserName(String userName) {
        CarOwner carOwner = carOwnerRepository.findByUserName(userName);
        CarOwnerDto carOwnerDto = getCarOwnerDto(carOwner);
        return carOwnerDto;
    }

    public void deleteById(Long id) {
        carOwnerRepository.deleteById(id);
    }

    public void resetPassword(CarOwner carOwner) {
        CarOwner carOwnerToUpdate = carOwnerRepository.getOne(carOwner.getId());
        carOwnerToUpdate.setPassword(carOwner.getPassword());
        carOwnerRepository.save(carOwnerToUpdate);
    }

    //for CarOwner => CarOwnerDto
    public CarOwnerDto getCarOwnerDto(CarOwner carOwner) {
        CarOwnerDto carOwnerDto = new CarOwnerDto(carOwner.getId(),
                carOwner.getEmail(),
                carOwner.getPassword(),
                carOwner.getFullName(),
                carOwner.getUserName());
        return carOwnerDto;
    }

}
