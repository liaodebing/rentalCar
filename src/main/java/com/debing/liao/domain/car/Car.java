package com.debing.liao.domain.car;

import lombok.Data;

/**
 * @author liaodebing
 */
@Data
public class Car {

    private Long id;

    /**
     * the number of free to rental
     */
    private Long stock;

    /**
     * the total number of the car with this model
     */
    private Long totalNumber;

    /**
     * car model
     *
     * @see com.debing.liao.domain.contants.CarModelEnum
     */
    private String model;

    /**
     * add something description for this car
     */
    private String description;
}
