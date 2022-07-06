package com.debing.liao.controller;

import com.debing.liao.common.Result;
import com.debing.liao.domain.car.Car;
import com.debing.liao.domain.customer.Customer;
import com.debing.liao.domain.rental.RentalInfo;
import com.debing.liao.service.RentalCarBizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaodebing
 */
@RestController
@RequestMapping("/car")
public class RentalCarRemoteController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RentalCarRemoteController.class);

    @Autowired
    private RentalCarBizService rentalCarBizService;


    @PostMapping("/rental")
    public Result<Car> rentalCar(Customer customer, RentalInfo rentalInfo) {
        LOGGER.info("rental car begin, param customer={}, rentalRequest={}", customer, rentalInfo);
        Car car = rentalCarBizService.rentalCar(customer, rentalInfo);
        LOGGER.info("rental car end, car={}", car);
        return car == null ? Result.failOf("rentalCar error please contact admin", car)
                : Result.successOf(car);
    }

    @PostMapping("/return")
    public Result<Boolean> returnCar(Customer customer, RentalInfo rentalInfo) {
        LOGGER.info("return car begin, param customer={}, rentalRequest={}", customer, rentalInfo);
        boolean result = rentalCarBizService.returnCar(customer, rentalInfo);
        LOGGER.info("return car end, result={}", result);
        return result ? Result.failOf("return car error please contact admin", true)
                : Result.successOf(false);
    }
}
