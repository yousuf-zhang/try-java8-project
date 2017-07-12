package com.java8.chap3;


import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by zhangshuai on 2017/7/7.
 * 环绕执行模式
 */
public class ExecuteAround {
    public static void main(String[] args) throws Exception {
        String result = processFileLimited();
        System.out.println(result);
    }

    public static String processFileLimited() throws Exception{
        //F:\IdeaProjects\try-java_8-project\src\main\resources\chap3\data.txt
        try(BufferedReader br = new BufferedReader(
                new FileReader("F:\\IdeaProjects\\try-java8-project\\src\\main\\resources\\chap3\\data.txt"))){
            return br.readLine();
        }
    }
}
