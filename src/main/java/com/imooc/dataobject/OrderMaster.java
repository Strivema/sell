package com.imooc.dataobject;


import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@DynamicUpdate
@Data
public class OrderMaster {
    /** 订单id. */
    @Id
    private String orderId;
    /** 买家名字. */
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;

    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    private Date createTime;
    private Date updateTime;

    /**
     * 數據庫裏 OrderMaster本來就沒有OrderDetail。
     * 所以可以加这个注解@Transient，去数据库里映射的时候就会忽略了。。因为数据库里没有这个字段
     *
     * 但是这么做，不是很好，因为这个类一方面对应数据库的字段，另一方面又要给外部的controller用，所以有点乱
     *
     * 好的做法是重新写一个类 OrderDTO 。 写在dto包里。data transfer object 数据传输对象。专门放中间传输的数据。
     *//*
    @Transient
    List<OrderDetail> orderDetailList;*/




}
