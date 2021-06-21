package com.watmap.server.repository;

import com.watmap.server.entity.Institute;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends CrudRepository<Institute, Integer> {
}
