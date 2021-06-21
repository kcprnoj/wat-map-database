package com.watmap.server.entity.dto;

import com.watmap.server.entity.Faculty;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class FacultyDto {
    private Integer id;
    private String name;
    private String shortName;
    private String url;
    private String description;
    private List<InstituteDto> institutes = new ArrayList<>();

    public static FacultyDto from(Faculty faculty){
        FacultyDto facultyDto = new FacultyDto();
        facultyDto.setId(faculty.getId());
        facultyDto.setName(faculty.getName());
        facultyDto.setShortName(faculty.getShortName());
        facultyDto.setDescription(faculty.getDescription());
        facultyDto.setInstitutes(faculty.getInstitutes().stream().map(InstituteDto::from).collect(Collectors.toList()));
        facultyDto.setUrl(faculty.getUrl());
        return facultyDto;
    }
}
