package com.debing.liao.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;



@RunWith(PowerMockRunner.class)
public class CustomerBizServiceImplTest {

    @InjectMocks
    private CustomerBizServiceImpl customerBizService;

    @Test
    public void registerTest() {
        long result = customerBizService.register("liaodebing", "12345675432");
        Assert.assertEquals(1, result);
    }

    @Test
    public void logOffTest() {
        boolean result = customerBizService.logOff("liaodebing","423423");
        Assert.assertFalse(result);
    }
}