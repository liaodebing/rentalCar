package com.debing.liao.domain.rental;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author liaodebing
 */
@Data
@ToString
public class RentalInfo {

    /**
     * rental car begin time
     */
    private Date startTime;

    /**
     * customer wants to rental a car.
     * which place he/she can get the car.
     */
    private String startArea;

    /**
     * rental car duration time
     */
    private Date durationTime;

    /**
     * which model you want to rental
     *
     * @see com.debing.liao.domain.contants.CarModelEnum
     */
    private String carModel;

    /**
     * how many cars you want to rental
     */
    private Integer rentalNumber;


}
