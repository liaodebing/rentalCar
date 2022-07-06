package com.debing.liao.service.impl;

import com.debing.liao.domain.car.Car;
import com.debing.liao.domain.contants.CarModelEnum;
import com.debing.liao.domain.contants.CustomerStatusEnum;
import com.debing.liao.domain.customer.Customer;
import com.debing.liao.domain.rental.RentalInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class RentalCarBizServiceImplTest {

    @InjectMocks
    private RentalCarBizServiceImpl rentalCarBizService;


    /**
     * test normal flow
     */
    @Test
    public void rentalCarTest() {
        Customer customer = buildCustomer();
        RentalInfo rentalInfo = buildRentalInfo();
        Car car = rentalCarBizService.rentalCar(customer, rentalInfo);

        Assert.assertNotNull(car);
    }

    /**
     * test different customer
     */
    @Test
    public void rentalCarTestPhone() {
        Customer customer = buildCustomerPhoneDiff();
        RentalInfo rentalInfo = buildRentalInfo();
        Car car = rentalCarBizService.rentalCar(customer, rentalInfo);

        Assert.assertNull(car);
    }

    /**
     * test different car model
     */
    @Test
    public void rentalCarTestModel() {
        Customer customer = buildCustomer();
        RentalInfo rentalInfo = buildRentalInfoModelDiff();
        Car car = rentalCarBizService.rentalCar(customer, rentalInfo);

        Assert.assertNull(car);
    }

    /**
     * test normal flow
     */
    @Test
    public void returnCarTest() {
        boolean result = rentalCarBizService.returnCar(buildCustomer(), buildRentalInfo());

        Assert.assertTrue(result);
    }

    /**
     * test different model
     */
    @Test
    public void returnCarTestModel() {
        boolean result = rentalCarBizService.returnCar(buildCustomer(), buildRentalInfoModelDiff());

        Assert.assertFalse(result);
    }

    private Customer buildCustomer() {
        Customer customer = new Customer();
        customer.setName("liaodebing");
        customer.setPhone("11223322121");
        customer.setId(1L);
        customer.setStatus(CustomerStatusEnum.LEGAL.getStatusCode());

        return customer;
    }

    private Customer buildCustomerPhoneDiff() {
        Customer customer = new Customer();
        customer.setName("liaodebing");
        customer.setPhone("23434234");
        customer.setId(1L);
        customer.setStatus(CustomerStatusEnum.LEGAL.getStatusCode());

        return customer;
    }

    private RentalInfo buildRentalInfo() {
        RentalInfo rentalInfo = new RentalInfo();
        rentalInfo.setRentalNumber(1);
        rentalInfo.setCarModel(CarModelEnum.TOYOTA_CAMRY.getModel());
        rentalInfo.setStartTime(new Date());
        rentalInfo.setDurationTime(new Date(2022, Calendar.OCTOBER,1));
        rentalInfo.setStartArea("shenzhen");

        return rentalInfo;
    }

    private RentalInfo buildRentalInfoModelDiff() {
        RentalInfo rentalInfo = new RentalInfo();
        rentalInfo.setRentalNumber(1);
        rentalInfo.setCarModel(CarModelEnum.BMW_650.getModel());
        rentalInfo.setStartTime(new Date());
        rentalInfo.setDurationTime(new Date(2022, Calendar.OCTOBER,1));
        rentalInfo.setStartArea("shenzhen");

        return rentalInfo;
    }
}