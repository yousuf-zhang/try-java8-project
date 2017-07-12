package com.java8.chap3;

/**
 * Created by zhangshuai on 2017/7/6.
 * lambda表达式： (parameters) ->  expression
 * 或者 (parameters) ->  {statements}
 *
 * 函数式接口：只有一个抽象方法的接口称为函数式接口，可以定义多个默认方法
 */
public class Lambdas {
    public static void main(String[] args) {
        //使用lambda
        Runnable r1 = () -> System.out.println("Hello world 1");

        //使用匿名类
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world 2");
            }
        };
        process(r1);
        process(r2);
        //可以直接传递lambda表达式
        process(() -> System.out.println("Hello world 3"));
    }

    public static void process(Runnable r) {
        r.run();
    }
}
