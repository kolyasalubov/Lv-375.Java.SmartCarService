package ua.ita.smartcarservice.controller;

import java.util.List;

import ua.ita.smartcarservice.dto.stoDto.CarOwnerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ua.ita.smartcarservice.entity.car.CarOwner;
import ua.ita.smartcarservice.service.impl.CarOwnerServiceImpl;

@RestController
public class CarOwnerController {
	
	@Autowired
	private CarOwnerServiceImpl carOwnerService;

//if passing @RequestBody in Postman => Doesn't support media type utf8?
	@PostMapping ("/carowner")
	public void createCarOwner (@RequestParam(value = "email") String email,
									   @RequestParam(value = "password") String password,
									   @RequestParam(value = "fullname") String fullname,
									   @RequestParam(value = "username") String username){

		CarOwner newCarOwner = new CarOwner (email,password,fullname, username);
		carOwnerService.create(newCarOwner);
	}


	@DeleteMapping("/carowner")
	public void  deleteCarOwner (@RequestParam (value = "id") Long id) {
		carOwnerService.deleteById(id);
	}
	
	@GetMapping ("/carowner")

	public CarOwnerDto getCarOwnerById (@RequestParam (value = "id")  Long id){
		return carOwnerService.getCarOwnerById(id);
	}
	
	@GetMapping ("/carowners/all")
	public List<CarOwnerDto> findAll (){
		return carOwnerService.findAll();
	}
	
	@GetMapping ("/carowner/username")
	public CarOwnerDto findByUserName (@RequestParam (value = "username") String username) {
		return carOwnerService.findByUserName(username);
	}
	
//TODO reset pass if needed

}