package com.imooc.service;

import com.imooc.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {

    /*给后台管理用的 买家端是用不到的 */
    ProductCategory findOne(Integer categoryId);

    /*给后台管理用的 买家端是用不到的 */
    List<ProductCategory> findAll();

    /** 买家端用到的是这个，通过类型来查  **/
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /** 新增和更新都是save方法 **/
    ProductCategory save(ProductCategory productCategory);
}
