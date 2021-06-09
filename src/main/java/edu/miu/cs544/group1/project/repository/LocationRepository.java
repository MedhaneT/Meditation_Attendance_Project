package edu.miu.cs544.group1.project.repository;

import edu.miu.cs544.group1.project.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
    Optional<Location> findByName(String name);
}
