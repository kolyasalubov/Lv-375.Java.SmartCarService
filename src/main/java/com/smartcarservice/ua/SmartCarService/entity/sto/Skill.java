package com.smartcarservice.ua.SmartCarService.entity.sto;


import com.smartcarservice.ua.SmartCarService.entity.sto.Worker;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "skill")
    Set<Worker> workers;

}
