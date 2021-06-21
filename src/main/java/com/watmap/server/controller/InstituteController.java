package com.watmap.server.controller;

import com.watmap.server.entity.Institute;
import com.watmap.server.entity.dto.InstituteDto;
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

    @Autowired
    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    @PostMapping
    public ResponseEntity<InstituteDto> addItem(@RequestBody final InstituteDto instituteDto){
        Institute institute = instituteService.addInstitute(Institute.from(instituteDto));
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
        Institute editedInstitute = instituteService.editInstitute(id, Institute.from(instituteDto));
        return new ResponseEntity<>(InstituteDto.from(editedInstitute), HttpStatus.OK);
    }

}
