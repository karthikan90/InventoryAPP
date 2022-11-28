package com.acs.interview.response;

import com.acs.interview.entity.AvailableSlot;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.Date;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Value
@Builder(builderClassName = "toBuilder", toBuilder = true)
public class TimeSlotResponse {

    Long id;

    Long empId;

    Date date;

    List<AvailableSlot> availableTimes;

    @JsonPOJOBuilder(withPrefix = EMPTY)
    public static class Builder {

    }
}
