package com.acs.interview.mapper;

import com.acs.interview.entity.TimeSlot;
import com.acs.interview.response.TimeSlotResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TimeSlotMapper implements Function<TimeSlot, TimeSlotResponse> {

    @Override
    public TimeSlotResponse apply(TimeSlot timeSlot) {
        return TimeSlotResponse.builder()
                .date(timeSlot.getDate())
                .id(timeSlot.getId())
                .empId(timeSlot.getEmpId())
                .availableTimes(timeSlot.getAvailableSlots())
                .build();
    }
}
