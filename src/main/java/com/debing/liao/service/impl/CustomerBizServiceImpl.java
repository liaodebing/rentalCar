package com.debing.liao.service.impl;

import com.debing.liao.domain.contants.CustomerStatusEnum;
import com.debing.liao.domain.customer.Customer;
import com.debing.liao.service.CustomerBizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author liaodebing
 */
@Service
public class CustomerBizServiceImpl implements CustomerBizService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerBizServiceImpl.class);

    @Override
    public Long register(String name, String phone) {
        // step list
        // 1 check db if exist this customer
        // 2 add customer to db

        Customer customerDB = getCustomerFromDB(name, phone);
        if (customerDB != null) {
            LOGGER.error("exist customer,name={},phone={}", name, phone);
            return -1L;
        }

        Customer customer = new Customer();
        customer.setName(name);
        customer.setPhone(phone);

        // todo save to DB return id
        // todo return customer.getId();
        LOGGER.info("register success,name={}", name);
        return 1L;
    }

    @Override
    public Boolean logOff(String name, String phone) {
        // step list
        // 1 check db if exist this customer
        // 2 drop off this customer (software delete)

        Customer customerDB = getCustomerFromDB(name, phone);
        if (customerDB == null) {
            LOGGER.error("customer not exist,name={},phone={}", name, phone);
            return false;
        }

        customerDB.setStatus(CustomerStatusEnum.LOG_OFF.getStatusCode());

        // todo update customer status
        return true;
    }

    private Customer getCustomerFromDB(String name, String phone) {
        //fake customer not exist
        return null;
    }
}
