package com.watmap.server.repository;
import com.watmap.server.entity.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
    Faculty findByShortName(String shortName);
}
