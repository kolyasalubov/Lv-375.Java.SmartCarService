package ua.ita.smartcarservice.controller.alerts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.ita.smartcarservice.dto.CarDto;
import ua.ita.smartcarservice.dto.alerts.FaultCodeDto;
import ua.ita.smartcarservice.dto.alerts.NotificationsDto;
import ua.ita.smartcarservice.service.CarService;
import ua.ita.smartcarservice.service.alerts.FaultCodeService;
import ua.ita.smartcarservice.service.alerts.NotificationService;
import ua.ita.smartcarservice.service.sensors.SensorService;

import java.sql.Timestamp;

@RestController
@RequestMapping("/api")
public class FaultCodeController {
	
	private final Boolean VISIBILITY = true;
	
	FaultCodeService faultCodeService;
	CarService carService;
	NotificationService notificationsService;
	SensorService sensorService;
	
	@Autowired
	public FaultCodeController(FaultCodeService faultCodeService,
							   CarService carService,
							   NotificationService notificationsService, 
							   SensorService sensorService) {
		this.faultCodeService = faultCodeService;
		this.carService = carService;
		this.notificationsService = notificationsService;
		this.sensorService = sensorService;
	}
	
	/* Method for handling fault code received from car */
	@PostMapping("/faultCode")
	public void handleFaultCode(@RequestParam(value="vinNumber") String vinNumber,
							   	   @RequestParam(value="code") String code) {
		try {
			FaultCodeDto faultCode = faultCodeService.getFaultCode(code);
			CarDto car = carService.findByVin(vinNumber);
			NotificationsDto toSave = new NotificationsDto(faultCode, car);
			notificationsService.saveNotification(toSave);
		} catch (Exception e) {
			System.out.println("FaultCode error: " + e.getMessage());
		}
	}
}
