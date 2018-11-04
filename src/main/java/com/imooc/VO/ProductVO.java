package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.imooc.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * 商品信息（包含类目）   返回给前端的
 */
@Data
public class ProductVO {

    @JsonProperty("name")  //对象序列化给前端，这个属性名就是name了
    private String categoryName;  //命名要规范，一看要知道是什么意思

    @JsonProperty("type")
    private Integer categoryType;

    /**
     * List里面是ProductInfoVO，而不是数据库的ProductInfo。为什么？
     * 一般来说，前端需要什么字段后端就提供哪些字段就好了。
     * 很大程度上是出于安全和隐私考虑，比如说库存返回给前端，给竞争对手看到 就不太好
     */
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


}
