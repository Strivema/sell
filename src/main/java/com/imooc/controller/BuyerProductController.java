package com.imooc.controller;


import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductInfoService;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 买家商品
 */

@RestController
@RequestMapping(value = "/buyer/product")
public class BuyerProductController {

    @Autowired
    private CategoryService categoryService;  //如何注入的？？？？，通过反射给field赋值的
    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping("/list")
    public ResultVO list(){
        //1、查所有已经上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2、查询类目（名字和类型）  所有的一次性查出来.. 从商品中取    .... 这里用到了java8的lambda表达式
        List<Integer> categoryTypeList = productInfoList.stream().
                map(productInfo -> productInfo.getCategoryType()).
                collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);
        //3、组装成 前端格式。。 这个不是业务逻辑。
        List<ProductVO> productVOList = new ArrayList<>();
        productCategoryList.stream().forEach(productCategory -> {
            ProductVO productVO1 = new ProductVO();                         //注意这个new放在里面
            productVO1.setCategoryType(productCategory.getCategoryType());
            productVO1.setCategoryName(productCategory.getCategoryName());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();   //注意这个new放在里面
            productInfoList.stream().filter(productInfo ->
                    Objects.equals(productCategory.getCategoryType(),productInfo.getCategoryType())).
                    forEach(productInfo -> {
                ProductInfoVO productInfoVO = new ProductInfoVO();          //注意这个new放在里面
                BeanUtils.copyProperties(productInfo, productInfoVO);
                productInfoVOList.add(productInfoVO);
                productVO1.setProductInfoVOList(productInfoVOList);
            });
            productVOList.add(productVO1);
        });
        return ResultVOUtil.success(productVOList);
    }



}
