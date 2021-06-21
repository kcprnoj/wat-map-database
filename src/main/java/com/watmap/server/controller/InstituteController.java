package com.watmap.server.controller;

import com.watmap.server.entity.Institute;
import com.watmap.server.entity.dto.InstituteDto;
import com.watmap.server.service.FacultyService;
import com.watmap.server.service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/institutes")
public class InstituteController {
    private final InstituteService instituteService;
    private final FacultyService facultyService;

    @Autowired
    public InstituteController(InstituteService instituteService, FacultyService facultyService) {
        this.instituteService = instituteService;
        this.facultyService = facultyService;
    }

    @PostMapping
    public ResponseEntity<InstituteDto> addItem(@RequestBody final InstituteDto instituteDto){
        Institute institute = Institute.from(instituteDto);
        institute.setFaculty(facultyService.getFaculty(instituteDto.getFacultyId()));
        institute = instituteService.addInstitute(institute);
        return new ResponseEntity<>(InstituteDto.from(institute), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InstituteDto>> getInstitutes(){
        List<Institute> institutes = instituteService.getInstitutes();
        List<InstituteDto> institutesDto = institutes.stream().map(InstituteDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(institutesDto, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<InstituteDto> getInstitute(@PathVariable final Integer id) {
        Institute institute = instituteService.getInstitute(id);
        return new ResponseEntity<>(InstituteDto.from(institute), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<InstituteDto> deleteInstitute(@PathVariable final Integer id) {
        Institute institute = instituteService.deleteInstitute(id);
        return new ResponseEntity<>(InstituteDto.from(institute), HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<InstituteDto> editInstitute(@PathVariable final Integer id,
                                                      @RequestBody final InstituteDto instituteDto) {
        Institute editedInstitute = Institute.from(instituteDto);
        editedInstitute = instituteService.editInstitute(id, editedInstitute);
        return new ResponseEntity<>(InstituteDto.from(editedInstitute), HttpStatus.OK);
    }

}
