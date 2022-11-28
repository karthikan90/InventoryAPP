package com.acs.interview.response;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Value
@Builder(builderClassName = "toBuilder", toBuilder = true)
public class LeaderBoardRequestDto {

    Integer userId;

    Integer year;

    String value;

    String mode;

    @JsonPOJOBuilder(withPrefix = EMPTY)
    public static class Builder {

    }
}
