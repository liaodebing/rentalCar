package com.debing.liao.controller;

import com.debing.liao.common.Result;
import com.debing.liao.service.CustomerBizService;
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
@RequestMapping("/customer")
public class CustomerRemoteController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerRemoteController.class);

    @Autowired
    private CustomerBizService customerBizService;


    @PostMapping("/register")
    public Result<Boolean> register(String name, String phone) {
        LOGGER.info("register begin, param name={},phone={}", name, phone);
        boolean result = customerBizService.register(name, phone) > 0;
        LOGGER.info("register end, result={}", result);

        return result ? Result.successOf(true) : Result.failOf("exist customer", false);
    }

    @PostMapping("/log/off")
    public Result<Boolean> logOff(String name, String phone) {
        LOGGER.info("logOff begin, param name={},phone={}", name, phone);
        boolean result = customerBizService.logOff(name, phone);
        LOGGER.info("logOff end, result={}", result);
        return result ? Result.successOf(true) : Result.failOf("customer not exist", false);
    }
}
