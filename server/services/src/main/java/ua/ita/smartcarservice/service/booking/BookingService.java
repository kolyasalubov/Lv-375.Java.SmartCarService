package ua.ita.smartcarservice.service.booking;

import ua.ita.smartcarservice.dto.booking.BookingDto;
import ua.ita.smartcarservice.dto.booking.NewBookingDto;
import ua.ita.smartcarservice.dto.booking.ReportDto;
import ua.ita.smartcarservice.dto.booking.WorkTimeDto;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    List<LocalDateTime> findTimeToBooking(BookingDto bookingDto);

    void addBooking(NewBookingDto newSessionDto);

    List <WorkTimeDto> findAllByWorkerId(Long workerId);

    List <WorkTimeDto> findAllByCarId(Long carId);

    void updateReportsId(ReportDto reportDto, Long reportId);
}
