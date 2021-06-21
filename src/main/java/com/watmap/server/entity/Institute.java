package com.watmap.server.entity;

import com.watmap.server.entity.dto.InstituteDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Institute")
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private int number;
    private double latitude;
    private double longitude;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Institute() {

    }

    public Institute(String name, String description, int number, double latitude, double longitude, Faculty faculty) {
        this.name = name;
        this.description = description;
        this.number = number;
        this.latitude = latitude;
        this.longitude = longitude;
        this.faculty = faculty;
    }

    public static Institute from(InstituteDto instituteDto) {
        Institute institute = new Institute();;
        institute.setName(instituteDto.getName());
        institute.setDescription(instituteDto.getDescription());
        institute.setNumber(instituteDto.getNumber());
        institute.setLatitude(instituteDto.getLatitude());
        institute.setLongitude(instituteDto.getLongitude());
        return institute;
    }

}
