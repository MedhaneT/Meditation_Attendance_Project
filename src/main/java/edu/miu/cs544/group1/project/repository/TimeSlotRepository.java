package edu.miu.cs544.group1.project.repository;

import edu.miu.cs544.group1.project.domain.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TimeSlotRepository extends JpaRepository<TimeSlot,Integer> {
}
