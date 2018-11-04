package com.imooc.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;


/***
 * 商品表 映射
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    /** 主键，不过这个productId不是自增的，是我们生成的随机字符 **/
    private String productId;
    private String productName;
    /** 单价 **/
    private BigDecimal productPrice;
    /** 库存 **/
    private Integer productStock;
    /** 描述 **/
    private String productDescription;
    /** 小图 **/
    private String productIcon;
    /** 商品状态,0正常1下架 **/
    private Integer productStatus;
    /** 类目编号  商品和类目的关系就用类目编号来做关联、、**/
    private Integer categoryType;

    public ProductInfo() {
    }
}
