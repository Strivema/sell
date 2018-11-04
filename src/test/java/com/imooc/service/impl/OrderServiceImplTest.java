package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;
    private final String BUYER_OPENID = "1101110";
    private final String ORDER_ID = "15231873616327807417";
    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("廖师兄");
        orderDTO.setBuyerAddress("幕课网");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车 ，也就是orderDetailList里的东西
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123457");
        o1.setProductQuantity(2);
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("12345");
        o2.setProductQuantity(3);

        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result={}", result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    /**
     * @throws Exception
     */
    @Test
    public void cancel() throws Exception {
        //取消订单，要更新一条记录的时候，首先要判断下该记录的状态。只有指定的状态下，订单才能被取消。
        //如果订单已经是完结状态，那就不能被取消。
        OrderDTO orderDTO  = orderService.findOne(ORDER_ID);
        OrderDTO cancelResult  = orderService.cancel(orderDTO);

        Assert.assertEquals(cancelResult.getOrderStatus(), OrderStatusEnum.CANCEL.getCode());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO  = orderService.findOne(ORDER_ID);
        OrderDTO cancelResult  = orderService.finish(orderDTO);

        Assert.assertEquals(cancelResult.getOrderStatus(), OrderStatusEnum.FINISHED.getCode());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO  = orderService.findOne(ORDER_ID);
        OrderDTO cancelResult  = orderService.paid(orderDTO);

        Assert.assertEquals(cancelResult.getPayStatus(), PayStatusEnum.SUCCESS.getCode());

    }

}