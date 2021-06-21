package com.watmap.server.entity.dto;

import com.watmap.server.entity.Institute;
import lombok.Data;

@Data
public class InstituteDto {
    private Integer id;
    private String name;
    private String description;
    private int number;
    private double latitude;
    private double longitude;
    private int facultyId;

    public static InstituteDto from(Institute institute){
        InstituteDto instituteDto = new InstituteDto();
        instituteDto.setId(institute.getId());
        instituteDto.setName(institute.getName());
        instituteDto.setDescription(institute.getDescription());
        instituteDto.setNumber(institute.getNumber());
        instituteDto.setLatitude(institute.getLatitude());
        instituteDto.setLongitude(institute.getLongitude());
        instituteDto.setFacultyId(institute.getFaculty().getId());
        return instituteDto;
    }
}
