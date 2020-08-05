package com.cheng.collection;

import java.util.ArrayList;
import java.util.Vector;
import java.util.function.Predicate;

/**
 * collection 接口下的集合
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-15
 */
public class CollectionInterface {

    /**
     * list 接口
     */
    public void ListInterface(){


        /**
         * 有序，可重复
         * 底层使用数组
         * 读取快，增删慢
         * 线程不安全
         * 默认 10， 1.5倍的扩容机制
         */
        ArrayList<String> arrayList = new ArrayList<String>(Integer.MAX_VALUE);

        /**
         * 有序，可重复，数组，读快，增删慢
         * 线程安全
         * 默认10 2倍扩容
         */
        Vector<String> vector = new Vector<String>();
        vector.add(String.valueOf(1));


    }
}
