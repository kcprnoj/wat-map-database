package com.watmap.server.entity;


import com.watmap.server.entity.dto.FacultyDto;
import com.watmap.server.entity.dto.InstituteDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "Faculty", uniqueConstraints=@UniqueConstraint(columnNames={"shortName"}))
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String shortName;
    private String url;
    private String description;

    @OneToMany(
            mappedBy = "faculty",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Institute> institutes = new ArrayList<>();

    public Faculty() {

    }

    public Faculty(String name, String shortName, String url, String description) {
        this.name = name;
        this.shortName = shortName;
        this.url = url;
        this.description = description;
    }

    public void addInstitute(Institute institute) {
        institutes.add(institute);
    }

    public void removeInstitute(Institute institute) {
        institutes.remove(institute);
    }

    public static Faculty from(FacultyDto facultyDto){
        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        faculty.setInstitutes(facultyDto.getInstitutes().stream().map(Institute::from).collect(Collectors.toList()));
        faculty.setShortName(facultyDto.getShortName());
        faculty.setDescription(facultyDto.getDescription());
        faculty.setUrl(facultyDto.getUrl());
        return faculty;
    }
}