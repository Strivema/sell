package com.imooc.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity //把数据库表映射成对象
@DynamicUpdate  //这个是让数据库自动更新时间的注解，时间字段就不在实体类里面了
@Data     //lombok是印尼一个岛的名字。。注解的性能和之前手写get set是完全一样的。程序编译好之后，get set代码已经写好了
/**
 *
 *      这里其实就是做一个数据库的映射。。。
 *  这里命名是驼峰法，但是数据库表名是下划线，这也是spring-data-jpa帮转换的。
 *  如果表名就是和类型不一致怎么写呢？
 *  就用@Table(name = "s_product_category"),这也是hibernate的知识点
 */
public class ProductCategory {

    /** 类目id. **/
    @Id
    @GeneratedValue
    private Integer categoryId;
    /** 类目名字. **/
    private String categoryName;
    /** 类目类型. **/
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
