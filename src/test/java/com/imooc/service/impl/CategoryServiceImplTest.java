package com.imooc.service.impl;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),productCategory.getCategoryId());
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> result = categoryService.findAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> result = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertEquals(2,result.size());
    }

    /***
     *  一个快捷键，shift+回车。。  直接跳到下一行。。
     * @throws Exception
     */
    @Test
    public void save() throws Exception {
        ProductCategory productCategory = categoryService.save(new ProductCategory("男生最爱", 4));
        Assert.assertNotNull(productCategory);
    }

}