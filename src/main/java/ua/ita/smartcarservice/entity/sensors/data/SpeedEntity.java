package ua.ita.smartcarservice.entity.sensors.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "fact_speed")
public class SpeedEntity extends SensorEntity implements ISensorEntity {

}
