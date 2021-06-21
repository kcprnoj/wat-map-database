package com.watmap.server.controller;

import com.watmap.server.entity.Faculty;
import com.watmap.server.entity.dto.FacultyDto;
import com.watmap.server.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<FacultyDto> addFaculty(@RequestBody final FacultyDto facultyDto){
        Faculty faculty = facultyService.addFaculty(Faculty.from(facultyDto));
        return new ResponseEntity<>(FacultyDto.from(faculty), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FacultyDto>>  getFaculties(){
        List<Faculty> faculties = facultyService.getFaculties();
        List<FacultyDto> facultiesDto = faculties.stream().map(FacultyDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(facultiesDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<FacultyDto> getFaculty(@PathVariable final Integer id){
        Faculty faculty = facultyService.getFaculty(id);
        return new ResponseEntity<>(FacultyDto.from(faculty), HttpStatus.OK);
    }

    @GetMapping(value = "/short/{shortName}")
    public ResponseEntity<FacultyDto> getFaculty(@PathVariable final String shortName){
        Faculty faculty = facultyService.getFaculty(shortName);
        System.out.println(faculty.getName());
        return new ResponseEntity<>(FacultyDto.from(faculty), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<FacultyDto> deleteFaculty(@PathVariable final Integer id){
        Faculty faculty = facultyService.deleteFaculty(id);
        return new ResponseEntity<>(FacultyDto.from(faculty), HttpStatus.OK);
    }

    @DeleteMapping(value = "/short/{shortName}")
    public ResponseEntity<FacultyDto> deleteFaculty(@PathVariable final String shortName){
        Faculty faculty = facultyService.deleteFaculty(shortName);
        return new ResponseEntity<>(FacultyDto.from(faculty), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<FacultyDto> editFaculty(@PathVariable final Integer id,
                                                  @RequestBody final FacultyDto facultyDto){
        Faculty faculty = facultyService.editFaculty(id, Faculty.from(facultyDto));
        return new ResponseEntity<>(FacultyDto.from(faculty), HttpStatus.OK);
    }

    @PutMapping(value = "/short/{shortName}")
    public ResponseEntity<FacultyDto> editFaculty(@PathVariable final String shortName,
                                                  @RequestBody final FacultyDto facultyDto){
        Faculty faculty = facultyService.getFaculty(shortName);
        facultyService.editFaculty(faculty.getId(), Faculty.from(facultyDto));
        return new ResponseEntity<>(FacultyDto.from(faculty), HttpStatus.OK);
    }

    @PostMapping(value = "{facultyId}/institutes/{instituteId}/add")
    public ResponseEntity<FacultyDto> addFaculty(@PathVariable final Integer facultyId,
                                                 @PathVariable final Integer instituteId){
        Faculty faculty = facultyService.addInstituteToFaculty(facultyId, instituteId);
        return new ResponseEntity<>(FacultyDto.from(faculty), HttpStatus.OK);
    }
}
