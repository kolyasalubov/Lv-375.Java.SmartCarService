package ua.ita.smartcarservice.entity.sensors.data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fact_oil_level")
public class OilLevelEntity extends SensorEntity implements ISensorEntity {

}