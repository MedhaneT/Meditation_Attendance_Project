package edu.miu.cs544.group1.project.repository;

import edu.miu.cs544.group1.project.domain.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@Transactional
public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecord,Long> {
    Optional<AttendanceRecord> findByScanTime(LocalDateTime scanTime);

}
