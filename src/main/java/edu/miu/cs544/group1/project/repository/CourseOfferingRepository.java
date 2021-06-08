package edu.miu.cs544.group1.project.repository;

import edu.miu.cs544.group1.project.domain.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface CourseOfferingRepository extends JpaRepository<CourseOffering,Long> {
}
