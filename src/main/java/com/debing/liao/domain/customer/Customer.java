package com.debing.liao.domain.customer;

import com.debing.liao.domain.contants.CustomerStatusEnum;
import lombok.Data;
import lombok.ToString;

/**
 * @author liaodebing
 */
@Data
@ToString
public class Customer {

    private Long id;

    /**
     * customer name
     */
    private String name;

    /**
     * customer phone
     */
    private String phone;

    /**
     * the status of customer in the system
     *
     * @see CustomerStatusEnum
     */
    private String status;
}
