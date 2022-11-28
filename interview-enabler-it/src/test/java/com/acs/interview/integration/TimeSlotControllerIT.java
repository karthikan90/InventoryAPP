package com.acs.interview.integration;

import com.acs.interview.BaseIT;
import com.acs.interview.entity.TimeSlot;
import com.acs.interview.repo.TimeSlotRepo;
import com.acs.interview.request.TimeSlotRequest;
import com.acs.interview.response.TimeSlotResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TimeSlotControllerIT extends BaseIT {

    @Autowired
    private TimeSlotRepo timeSlotRepo;

    @BeforeEach
    public void setUp() {
        baseUrl = baseUrl.concat(String.valueOf(port)).concat("/timeslot");
    }

    @Test
    @DisplayName("This test cases uses to save the time slot")
    public void testSaveTimeSlot() {
        final TimeSlotRequest timeSlotRequest = TimeSlotRequest.builder()
                .empId(1414L)
                .date(new Date())
                .duration(30)
                .availableTimes(List.of(10, 12))
                .build();
        final ResponseEntity<TimeSlotResponse> response = testRestTemplate.postForEntity(baseUrl, timeSlotRequest, TimeSlotResponse.class);
        checkAssertions(response);
    }

    @Test
    @DisplayName("This test cases uses to get the time slot by employee id")
    public void testTimeSlotByEmpId() {
        final String url = baseUrl + "/{id}";
        final ResponseEntity<TimeSlotResponse> response = testRestTemplate.getForEntity(url, TimeSlotResponse.class, 1414);
        checkAssertions(response);
    }

    private void checkAssertions(final ResponseEntity<TimeSlotResponse> response) {
        final TimeSlotResponse timeSlotResponse =  response.getBody();

        assertNotNull(timeSlotResponse);
        final List<TimeSlot> timeSlots = timeSlotRepo.findAll();
        assertAll(
                () -> assertEquals(1, timeSlots.size()),
                () -> assertEquals(1414L, timeSlots.get(0).getEmpId())
        );

    }
}
