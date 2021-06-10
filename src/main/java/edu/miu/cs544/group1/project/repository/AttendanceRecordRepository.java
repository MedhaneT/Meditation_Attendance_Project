package edu.miu.cs544.group1.project.repository;

import edu.miu.cs544.group1.project.domain.AttendanceRecord;
import edu.miu.cs544.group1.project.domain.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord, Long> {
    Optional<AttendanceRecord> findByScanTime(LocalDateTime scanTime);

    @Query(value = "from AttendanceRecord where session.courseOffering = :courseOffering")
    List<AttendanceRecord> findByCourseOffering(
            @Param(value = "courseOffering") CourseOffering courseOffering);

}
