package com.debing.liao.service;

import com.debing.liao.domain.car.Car;
import com.debing.liao.domain.customer.Customer;
import com.debing.liao.domain.rental.RentalInfo;

/**
 * @author liaodebing
 */
public interface RentalCarBizService {
    Car rentalCar(Customer customer, RentalInfo rentalInfo);

    Boolean returnCar(Customer customer, RentalInfo rentalInfo);
}
