package com.acs.interview.repo;

import com.acs.interview.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {

    TimeSlot findByEmpId(final Long id);
}
