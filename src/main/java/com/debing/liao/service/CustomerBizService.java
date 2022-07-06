package com.debing.liao.service;

/**
 * @author liaodebing
 */
public interface CustomerBizService {

    /**
     * when customer wants to do some business with our company,
     * at first, he/she should do the register in our system
     *
     * @param name
     * @param phone
     * @return
     */
    Long register(String name, String phone);

    /**
     * customer wants has nothing connection with our company, just logOff.
     *
     * @param name
     * @param phone
     * @return
     */
    Boolean logOff(String name, String phone);
}
