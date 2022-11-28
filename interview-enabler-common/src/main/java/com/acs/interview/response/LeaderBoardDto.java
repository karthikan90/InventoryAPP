package com.acs.interview.response;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Value
@Builder(builderClassName = "toBuilder", toBuilder = true)
public class LeaderBoardDto {

    Integer userId;

    Integer rank;

    Integer totalPoints;

    String name;

    String location;

    String email;

    String imageUrl;

    @JsonPOJOBuilder(withPrefix = EMPTY)
    public static class Builder {

    }
}
