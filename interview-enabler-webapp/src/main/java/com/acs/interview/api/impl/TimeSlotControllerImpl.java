package com.acs.interview.api.impl;

import com.acs.interview.TimeSlotService;
import com.acs.interview.api.TimeSlotController;
import com.acs.interview.request.TimeSlotRequest;
import com.acs.interview.response.TimeSlotResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TimeSlotControllerImpl implements TimeSlotController {

    private final TimeSlotService timeSlotService;

    @Override
    public ResponseEntity<List<TimeSlotResponse>> get(){
        return ResponseEntity.ok(timeSlotService.get());
    }

    @Override
    public ResponseEntity<TimeSlotResponse> getByEmpId(final Long id) {
        return ResponseEntity.ok(timeSlotService.getByEmployeeId(id));
    }

    @Override
    public ResponseEntity<TimeSlotResponse> save(final TimeSlotRequest timeSlotRequest) {
        return new ResponseEntity<>(timeSlotService.save(timeSlotRequest),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TimeSlotResponse> update(final Long empId, final TimeSlotRequest timeSlotRequest) {
        return ResponseEntity.ok(timeSlotService.update(empId, timeSlotRequest));
    }
}
