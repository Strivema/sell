package com.imooc.utils;

import java.util.Random;

/**
 * 生成主键 随机数
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     *
     * 加synchronized是为了 生成订单id 不会重复
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(9000000) + 1000000;   //生成一个六位随机数
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
