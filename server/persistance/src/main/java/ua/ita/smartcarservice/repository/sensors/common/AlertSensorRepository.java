package ua.ita.smartcarservice.repository.sensors.common;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import ua.ita.smartcarservice.entity.sensors.BaseSensorEntity;

@NoRepositoryBean
public interface AlertSensorRepository<T extends BaseSensorEntity> extends BasicSensorRepository<T> {

    @Query("SELECT t FROM #{#entityName} t WHERE t.date IN "
            + "(SELECT MAX(date) FROM #{#entityName} WHERE date < :date)"
            + "AND t.car.id = :carId")
    T findRecordBeforeDate(@Param("date") LocalDateTime date,
                           @Param("carId") Long carId);
}

