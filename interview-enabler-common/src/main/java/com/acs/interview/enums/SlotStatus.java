package com.acs.interview.enums;

public enum SlotStatus {
    AVAILABLE("AVAILABLE"),
    SCHEDULED("SCHEDULED"),
    CANCELLED("CANCELLED");

    private final String status;

    SlotStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
