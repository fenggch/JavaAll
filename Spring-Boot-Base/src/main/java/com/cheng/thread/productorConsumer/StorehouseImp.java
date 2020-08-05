package com.cheng.thread.productorConsumer;

import java.util.LinkedList;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-28
 */
public class StorehouseImp implements IStorehouse {
    final  int MAX_SIZE = 100;
    LinkedList list = new LinkedList();


    @Override
    public void product(int num) {
        while (true){
            synchronized (list){
                // 容量不足
                while (list.size()+ num > MAX_SIZE){
                    System.out.println("仓库容量不足：" + list.size());
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < num; i++) {
                    list.add(new Object());
                }
                System.out.println("仓库现有存储：" + list.size());
                list.notifyAll();
            }
        }

    }

    @Override
    public void consumer(int num) {

        while (true){
            synchronized (list){
                while (list.size()< num){
                    // 没库存
                    System.out.println("库存不足：" + list.size());
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < num; i++) {
                    list.remove();
                }
                System.out.println("1仓库现有存储：" + list.size());
                list.notifyAll();
            }
        }

    }
}
