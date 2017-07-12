package com.java8.chap2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangshuai on 2017/7/6.
 */
public class FilterPredicate {
    /**
     * 把所有参数都进行抽象化处理
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for(T t : list) {
            if(p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * 抽象化行为参数
     * @param <T>
     * 函数式接口的注解：@FunctionalInterface
     */
    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }
}
