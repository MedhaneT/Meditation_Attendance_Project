package edu.miu.cs544.group1.project.repository;

import edu.miu.cs544.group1.project.domain.AttendanceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AttendaceRecordRepository extends JpaRepository<AttendanceRecord, Long> {
}
