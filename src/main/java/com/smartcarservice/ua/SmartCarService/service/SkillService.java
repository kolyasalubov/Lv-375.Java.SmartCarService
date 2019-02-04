package com.smartcarservice.ua.SmartCarService.service;

import com.smartcarservice.ua.SmartCarService.dto.stoDto.SkillDto;
import com.smartcarservice.ua.SmartCarService.entity.sto.Skill;

import java.util.List;

public interface SkillService {
    List<SkillDto> getAllSkills();
    SkillDto getSkillDto(Skill skill);
    Skill getSkillById(Long id);
}
