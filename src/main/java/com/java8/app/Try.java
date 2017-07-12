package com.java8.app;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by zhangshuai on 2017/7/6.
 */
public class Try {


    public void filterHiddenFile() {
        /**
         * 筛选影藏文件的方法
         * JDK1.7中通过内部类去实现
         */
        File[] hiddenFile = new File(".").listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        /**
         * JDK1.8以后的做法
         * '::' 把方法作为值传递
         * JDK1.8以前需要把方法包裹在对象里进行传递。
         * 现在可以直接使用函数
         * */
        hiddenFile = new File(".").listFiles(File :: isHidden);
    }
}
