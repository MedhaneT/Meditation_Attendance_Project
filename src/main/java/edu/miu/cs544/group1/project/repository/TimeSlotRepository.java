package edu.miu.cs544.group1.project.repository;

import edu.miu.cs544.group1.project.domain.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Transactional
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    Optional<TimeSlot> findByAbbreviation(String abbreviation);

    @org.springframework.data.jpa.repository.Query(
            value = "FROM TimeSlot WHERE :time BETWEEN startTime AND endTime")
    Optional<TimeSlot> getTimeSlot(@Param("time") LocalTime time);
}
