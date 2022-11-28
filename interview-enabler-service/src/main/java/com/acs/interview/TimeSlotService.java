package com.acs.interview;

import com.acs.interview.request.TimeSlotRequest;
import com.acs.interview.response.TimeSlotResponse;

import java.util.List;

public interface TimeSlotService {
    List<TimeSlotResponse> get();

    TimeSlotResponse getByEmployeeId(final Long id);

    TimeSlotResponse update(final Long id, final TimeSlotRequest timeSlotRequest);

    TimeSlotResponse save(final TimeSlotRequest timeSlotRequest);

}
