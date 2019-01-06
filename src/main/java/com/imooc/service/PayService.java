package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * 支付
 */
public interface PayService {

    void create(OrderDTO orderDTO);
}
