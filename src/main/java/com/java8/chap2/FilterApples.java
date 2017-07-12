package com.java8.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangshuai on 2017/7/6.
 * 重要思想：行为参数化，把所处理的逻辑作为参数传入方法中进行处理
 */
public class FilterApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        /*创建新对象*/
        List<Apple> greenApple = FilterApples.filter(inventory, new AppleColorPredicate());
        System.out.println(greenApple);

        List<Apple> redApples = FilterApples.filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return "red".equals(a.getColor());
            }
        });
        System.out.println(redApples);
        List<Apple> redApples2 = FilterApples.filter(inventory, apple -> "red".equals(apple.getColor()));
        System.out.println(redApples2);
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterAppleByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterAppleByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > weight) {
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

     interface ApplePredicate {
        boolean test(Apple a);
    }

    static class AppleColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return "green".equals(a.getColor());
        }
    }

    static class AppleWeghtPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return a.getWeight() > 150;
        }
    }

    static class AppleColorAndWeghtPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple a) {
            return "red".equals(a.getColor())
                    && a.getWeight() > 150;
        }
    }


}
