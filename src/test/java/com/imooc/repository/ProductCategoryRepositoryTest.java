package com.imooc.repository;

import com.imooc.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory.toString());
        Assert.assertNotNull(productCategory);
    }

    @Test
    @Transactional
    /***
     * 这个和service里的事务不一样，service里是抛异常就回滚。
     * 但是在test里面是所有事情都回复。测试数据是不会加到数据库里面去的，测试用例执行完，数据库是干净的。
     */
    public void saveTest(){
        //type在数据库里加了约束，必须是唯一的。   unique key `uqe_category_type` (`category_type`)
        ProductCategory productCategory = new ProductCategory("测试最爱",5);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null,result);
    }

    /***
     * 用
     * @throws Exception
     */
    @Test
    public void findAllByCategoryTypeIn() throws Exception {
        List<Integer> typeList = Arrays.asList(1,2);
        List<ProductCategory> result = repository.findAllByCategoryTypeIn(typeList);
        Assert.assertEquals(1, result.size());

    }

}