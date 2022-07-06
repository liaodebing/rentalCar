package com.debing.liao.domain.contants;

/**
 * @author liaodebing
 */
public enum CarModelEnum {

    TOYOTA_CAMRY("Toyota Camry", "Toyota Camry"),

    BMW_650("BMW 650", "BMW 650");

    /**
     * car model
     */
    private final String model;

    /**
     * car model description
     * add something description for the model
     */
    private final String description;

    CarModelEnum(String model, String description) {
        this.model = model;
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }
}
