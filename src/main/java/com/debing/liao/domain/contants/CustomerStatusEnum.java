package com.debing.liao.domain.contants;

/**
 * @author liaodebing
 */
public enum CustomerStatusEnum {

    LEGAL("LEGAL", "it means this is a legal customer"),

    LOG_OFF("LOG_OFF", "it means the customer had left the system forever");


    private final String statusCode;

    private final String description;

    CustomerStatusEnum(String statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }
}
