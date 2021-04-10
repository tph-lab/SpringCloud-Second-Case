package com.yc.piclib.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CopyUtil {

    /**
     * 使用指定类初始化日志对象
     * <p>
     * 在日志输出的时候，可以打印出日志信息所在类
     * 如：Logger logger = LoggerFactory.getLogger(com.Book.class);
     * logger.debug("日志信息");
     * 将会打印出: com.Book : 日志信息
     */

    //使用指定类初始化日志对象
    private static Logger logger = LoggerFactory.getLogger(CopyUtil.class);

    /**
     * 复制对象
     *
     * @param src   原对象
     * @param clazz 对象类
     * @param <T>
     * @return 新的对象
     */
    //<T> T 表示的是返回值T是泛型，T是一个占位符，用来告诉编译器，这个东西先给我留着，等我编译的时候，告诉你。
    public static <T> T copy(Object src, Class<T> clazz) {
        if (src == null) {
            return null;
        }
        T t = null;
        try {

            t = clazz.newInstance();
            //一个JavaBean通常包含了大量的属性，很多情况下，对JavaBean的处理导致大量get/set代码堆积，增加了代码长度和阅读代码的难度。
            //而BeanUtils.copyProperties（）可以解决这个问题
            BeanUtils.copyProperties(src, t);
            return t;
        } catch (Exception e) {
            logger.error("复制文件出错", e);
        }
        return t;
    }

    /**
     * 复制对象list集合
     *
     * @param srclist 原对象集合
     * @param clazz   对象类
     * @param <T>
     * @return 新的对象
     */
    public static <T> List<T> copyList(Object srclist, Class<T> clazz) {
        if (srclist == null) {
            return null;
        }
        List<T> destlist = new ArrayList<T>();
        List<Object> srcLists = (List<Object>) srclist;//父类强转为子类
        for (Object src : srcLists) {
            destlist.add(copy(src, clazz));
        }
        return destlist;
    }
}