package ua.ita.smartcarservice.entity.sensors;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "fact_glass_washer_fluid")
public class GlassWasherFluidEntity extends SensorEntity {

}