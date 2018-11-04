package com.imooc.service;


import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 订单的服务/
 *
 * 一个订单主表可以对应好几个订单明细表。
 */
public interface OrderService {

    /*创建订单*/
    OrderDTO create(OrderDTO orderDTO);   //ProductInfoService接口里没有创建创建方法。

    /*查询单个订单*/
    OrderDTO findOne(String orderId);

    /*查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid,Pageable pageable);

    /*取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /*完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /*支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

}
