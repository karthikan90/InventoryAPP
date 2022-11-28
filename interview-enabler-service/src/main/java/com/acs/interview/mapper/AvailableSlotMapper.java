package com.acs.interview.mapper;

import com.acs.interview.entity.AvailableSlot;
import com.acs.interview.enums.SlotStatus;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.function.BiFunction;

@Component
public class AvailableSlotMapper implements BiFunction<Integer, Integer, AvailableSlot> {

    @Override
    public AvailableSlot apply(final Integer availableSlot, final Integer duration) {
        final LocalTime startTime = LocalTime.of(availableSlot, 0);
        final LocalTime endTime = startTime.plusMinutes(duration);
        return AvailableSlot.builder()
                .status(SlotStatus.AVAILABLE.getStatus())
                .startTime(startTime).endTime(endTime).build();
    }
}
