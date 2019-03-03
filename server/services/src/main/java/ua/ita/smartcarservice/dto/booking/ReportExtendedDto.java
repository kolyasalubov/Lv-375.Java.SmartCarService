package ua.ita.smartcarservice.dto.booking;

import ua.ita.smartcarservice.entity.Car;
import ua.ita.smartcarservice.entity.UserEntity;
import ua.ita.smartcarservice.entity.booking.WorkTime;
import ua.ita.smartcarservice.entity.technicalservice.TechnicalServiceEntity;

import java.util.List;

public class ReportExtendedDto {

    private ReportDto reportDto;

    private UserEntity user;

    private Car car;

    private TechnicalServiceEntity technicalService;

    private List<WorkTime> workTimes;
}
