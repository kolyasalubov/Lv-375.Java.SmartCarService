package ua.ita.smartcarservice.controller.technicalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.ita.smartcarservice.dto.booking.WorkTypeDto;
import ua.ita.smartcarservice.service.technicalservice.WorkTypeService;

import java.util.List;
import java.util.Map;

@RestController
public class WorkTypeController {

    @Autowired
    private WorkTypeService workTypeService;

    @GetMapping("/api/worksbycar/{id}")
    public ResponseEntity<Map<String, List<WorkTypeDto>>> findAlService(@PathVariable Long id){
        return new ResponseEntity<>(workTypeService.getAllService(id), HttpStatus.OK);
    }

}
