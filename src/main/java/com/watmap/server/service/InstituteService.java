package com.watmap.server.service;

import com.watmap.server.entity.Institute;
import com.watmap.server.entity.exception.FacultyNotFoundException;
import com.watmap.server.entity.exception.InstituteNotFoundException;
import com.watmap.server.repository.InstituteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InstituteService {

    private final InstituteRepository instituteRepository;

    @Autowired
    public InstituteService(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    public Institute addInstitute(Institute institute) {
        return instituteRepository.save(institute);
    }

    public List<Institute> getInstitutes() {
        return StreamSupport
                .stream(instituteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Institute getInstitute(Integer id) {
        return instituteRepository.findById(id).orElseThrow(() ->
                new InstituteNotFoundException(id));
    }

    public Institute deleteInstitute(Integer id) {
        Institute institute = getInstitute(id);
        instituteRepository.delete(institute);
        return institute;
    }

    @Transactional
    public Institute editInstitute(Integer id, Institute institute) {
        Institute instituteToEdit = getInstitute(id);
        instituteToEdit.setDescription(institute.getDescription());
        instituteToEdit.setName(institute.getName());
        instituteToEdit.setLatitude(institute.getLatitude());
        instituteToEdit.setLongitude(institute.getLongitude());
        instituteToEdit.setNumber(institute.getNumber());
        return instituteToEdit;
    }
}
