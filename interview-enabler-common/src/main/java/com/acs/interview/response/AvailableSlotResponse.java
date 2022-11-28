package com.acs.interview.response;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.sql.Timestamp;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Value
@Builder(builderClassName = "toBuilder", toBuilder = true)
public class AvailableSlotResponse {

    Long id;

    Timestamp startTime;

    Timestamp endTime;

    String status;

    @JsonPOJOBuilder(withPrefix = EMPTY)
    public static class Builder {

    }
}
