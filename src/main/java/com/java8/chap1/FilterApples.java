package com.java8.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by zhangshuai on 2017/7/6.
 *
 * 函数式变成的两个核心思想：
 *  1.将函数和lambda表达式作为一等值。
 *  2.在没有可变共享状态时，函数或方法可以有效、安全的并行执行。
 */
public class FilterApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        /*
         * 传递方法 FilterApples :: isGreenApple
         */
        List<Apple> greenApples = FilterApples.filterApples(inventory, FilterApples:: isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = FilterApples.filterApples(inventory, FilterApples:: isHeavyApple);
        System.out.println(heavyApples);

        /*-----------------------------------------------------------*/

        /*
         * 调用匿名函数 lambda表达式 (Apple a) -> "green".equals(a.getColor())
         * 这里默认为类名小写
         * 可以跟多个条件
         * */
        List<Apple> greenApples2 = FilterApples.filterApples(inventory,
                (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        List<Apple> heavyApples2 = FilterApples.filterApples(inventory, apple -> apple.getWeight() > 150);
        System.out.println(heavyApples2);

        List<Apple> weirdApples = FilterApples.filterApples(inventory, apple -> apple.getWeight() < 80
                || "brown".equals(apple.getColor()));
        System.out.println(weirdApples);
    }

    /***
     *
     * @param inventory
     * @return
     *
     * 判断是否是绿苹果的方法
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 判断是否超过150的重量
     * @param inventory
     * @return
     */
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    /**
     *
     * @param inventory
     * @param p
     * @return
     *
     * Predicate : 谓词(predicate)
     *   在数学上常常用来表示类似于一个函数的东西，返回true或者false
     *
     */
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
