package com.cheng.thread.productorConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-28
 */
public class WaitNotify {

    public static void main(String[] args) {
        IStorehouse storehouse = new StorehouseImp();

//        ExecutorService executorService = Executors.newFixedThreadPool(15);
//        for (int i = 0; i <10 ; i++) {
//            executorService.submit(new Productor(storehouse));
//        }
//        for (int i = 0; i <5 ; i++) {
//            executorService.submit(new Consumer(storehouse));
//
//        }
        for (int i = 0; i < 5; i++) {
            Productor productor = new Productor(storehouse);
            Thread thread = new Thread(productor);
            thread.start();
        }
        for (int i = 0; i < 10; i++) {
            Consumer consumer = new Consumer(storehouse);
            Thread thread = new Thread(consumer);
            thread.start();
        }

    }

    static class Productor implements Runnable{
        //每次生产的量
        int num = 3;

        IStorehouse storehouse;

        public Productor(IStorehouse storehouse){
            this.storehouse = storehouse;
        }
        @Override
        public void run() {
            storehouse.product(num);
        }
    }

    static class Consumer implements Runnable{
        //每次生产的量
        int num = 3;

        IStorehouse storehouse;
        public Consumer(IStorehouse storehouse){
            this.storehouse = storehouse;
        }
        @Override
        public void run() {
            storehouse.consumer(num);
        }
    }
}
