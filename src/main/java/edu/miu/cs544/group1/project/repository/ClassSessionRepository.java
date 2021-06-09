package edu.miu.cs544.group1.project.repository;

import edu.miu.cs544.group1.project.domain.ClassSession;
import edu.miu.cs544.group1.project.domain.Location;
import edu.miu.cs544.group1.project.domain.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ClassSessionRepository extends JpaRepository<ClassSession, Long> {
    @org.springframework.data.jpa.repository.Query(
            value = "FROM ClassSession WHERE" +
                    "   location = :location" +
                    "   AND :timeSlot IN elements(timeSlots)" +
                    "   AND current_date >= startDate" +
                    "   AND current_date <= startDate")
    Optional<ClassSession> findTodayClassSessionByLocationAndTimeSlot(
            @Param("location") Location location,
            @Param("timeSlot") TimeSlot timeSlot);
}
