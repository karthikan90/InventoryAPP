package com.acs.interview.repo;

import com.acs.interview.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepo extends JpaRepository<TimeSlot, Long> {
}
