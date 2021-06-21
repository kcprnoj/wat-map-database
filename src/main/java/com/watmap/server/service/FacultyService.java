package com.watmap.server.service;

import com.watmap.server.entity.Faculty;
import com.watmap.server.entity.Institute;
import com.watmap.server.entity.exception.FacultyNotFoundException;
import com.watmap.server.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final InstituteService instituteService;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository, InstituteService instituteService) {
        this.facultyRepository = facultyRepository;
        this.instituteService = instituteService;
    }

    public Faculty addFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getFaculties() {
        return StreamSupport
                .stream(facultyRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Faculty getFaculty(Integer id) {
        return facultyRepository.findById(id).orElseThrow(() ->
            new FacultyNotFoundException(id));
    }

    public Faculty getFaculty(String shortName) {
        return facultyRepository.findByShortName(shortName);
    }

    public Faculty deleteFaculty(Integer id) {
        Faculty faculty = getFaculty(id);
        facultyRepository.delete(faculty);
        return faculty;
    }

    public Faculty deleteFaculty(String shortName) {
        Faculty faculty = getFaculty(shortName);
        facultyRepository.delete(faculty);
        return faculty;
    }

    public Faculty editFaculty(Integer id, Faculty faculty) {
        Faculty facultyToEdit = getFaculty(id);
        facultyToEdit.setDescription(faculty.getDescription());
        facultyToEdit.setName(faculty.getName());
        facultyToEdit.setShortName(faculty.getShortName());
        facultyToEdit.setUrl(faculty.getUrl());
        return facultyToEdit;
    }

    public Faculty addInstituteToFaculty(Integer facultyId, Integer instituteId) {
        Faculty faculty = getFaculty(facultyId);
        Institute institute = instituteService.getInstitute(instituteId);
        faculty.addInstitute(institute);
        return faculty;
    }

    public Faculty removeInstituteFromFaculty(Integer facultyId, Integer instituteId) {
        Faculty faculty = getFaculty(facultyId);
        Institute institute = instituteService.getInstitute(instituteId);
        faculty.removeInstitute(institute);
        return faculty;
    }
}
