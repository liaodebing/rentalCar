package com.debing.liao.service.impl;

import com.debing.liao.domain.car.Car;
import com.debing.liao.domain.contants.CarModelEnum;
import com.debing.liao.domain.contants.CustomerStatusEnum;
import com.debing.liao.domain.customer.Customer;
import com.debing.liao.domain.rental.RentalInfo;
import com.debing.liao.service.RentalCarBizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author liaodebing
 */
@Service
public class RentalCarBizServiceImpl implements RentalCarBizService {

    private final static Logger LOGGER = LoggerFactory.getLogger(RentalCarBizServiceImpl.class);


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Car rentalCar(Customer customer, RentalInfo rentalInfo) {
        // step list
        // 1 check param is legal?
        // 2 get customer from db by param customer id, check customer is legal?
        // 3 get Car from db by param rentalInfo carModel, check rental info
        // 4 check car stock


        // step one
        if (customer == null || customer.getId() == null || customer.getName() == null || customer.getPhone() == null) {
            LOGGER.error("rental car customer error");
            return null;
        }
        if (rentalInfo == null || rentalInfo.getCarModel() == null || rentalInfo.getRentalNumber() == null
                || rentalInfo.getDurationTime() == null || rentalInfo.getStartTime() == null || rentalInfo.getStartArea() == null) {
            LOGGER.error("rental car rentalInfo error");
            return null;
        }


        // step two
        // fake object from db
        Customer customerDB = buildCustomer();
        // check customer info
        boolean checkCustomerResult = checkCustomerInfo(customer, customerDB);
        if (!checkCustomerResult) {
            return null;
        }


        // step three
        // fake object from db
        Car car = buildCar();
        if (car == null) {
            LOGGER.error("rental car model not exist");
            return null;
        }
        if (!Objects.equals(car.getModel(), rentalInfo.getCarModel())) {
            LOGGER.error("rental car model not match");
            return null;
        }



        // step four
        synchronized (car) {
            if (car.getStock() > 0) {
                // todo update db stock -1
                // todo add one relationship with customer and car model
                return car;
            }
        }


        return null;
    }

    @Override
    public Boolean returnCar(Customer customer, RentalInfo rentalInfo) {
        // step list
        // 1 check param
        // 2 check rental relationship between customer and car model
        // 3 return car


        // step one
        if (customer == null || customer.getId() == null || customer.getName() == null || customer.getPhone() == null) {
            LOGGER.error("return car customer error");
            return null;
        }
        if (rentalInfo == null || rentalInfo.getCarModel() == null || rentalInfo.getRentalNumber() == null
                || rentalInfo.getDurationTime() == null || rentalInfo.getStartTime() == null || rentalInfo.getStartArea() == null) {
            LOGGER.error("return car rentalInfo error");
            return null;
        }


        // step two
        Car car = getCustomerRentalCar(customer, rentalInfo);
        if (car == null) {
            LOGGER.error("rental car not exist, return car failed");
            return false;
        }
        if (!Objects.equals(car.getModel(), rentalInfo.getCarModel())) {
            LOGGER.error("rental car model not match, return car failed");
            return false;
        }



        // step three
        // todo db stock +1
        // todo remove the relationship between customer and car

        return true;
    }

    private Car getCustomerRentalCar(Customer customer, RentalInfo rentalInfo) {
        // todo it should get the rental car from db
        // fake data
        Car car = new Car();
        car.setModel(CarModelEnum.TOYOTA_CAMRY.getModel());
        return car;
    }

    private boolean checkCustomerInfo(Customer customerParam, Customer customerDB) {
        if (customerDB == null) {
            LOGGER.error("customer not exist");
            return false;
        }

        if (!Objects.equals(customerDB.getStatus(), CustomerStatusEnum.LEGAL.getStatusCode())) {
            LOGGER.error("customer status is illegal");
            return false;
        }

        if (!Objects.equals(customerDB.getName(), customerParam.getName()) || !Objects.equals(customerDB.getPhone(), customerParam.getPhone())) {
            LOGGER.error("customer");
            return false;
        }

        return true;
    }

    private Customer buildCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("liaodebing");
        customer.setPhone("11223322121");
        customer.setStatus(CustomerStatusEnum.LEGAL.getStatusCode());

        return customer;
    }

    private Car buildCar() {
        Car car = new Car();
        car.setId(1L);
        car.setStock(2L);
        car.setDescription("this is a new car");
        car.setTotalNumber(20L);
        car.setModel(CarModelEnum.TOYOTA_CAMRY.getModel());

        return car;
    }
}
