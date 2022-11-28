package com.acs.interview.request;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.List;

import static org.apache.logging.log4j.util.Strings.EMPTY;

@Value
@Builder(builderClassName = "toBuilder", toBuilder = true)
public class ReasonDetails {

    List<ReasonData> children;

    @JsonPOJOBuilder(withPrefix = EMPTY)
    public static class Builder {

    }
}
