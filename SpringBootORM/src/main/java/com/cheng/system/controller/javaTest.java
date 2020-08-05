package com.cheng.system.controller;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-03
 */
public class javaTest {

    private volatile
    static   int a = 5;
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i <10 ; i++) {
            threadPoolExecutor.execute(new addThread());
        }
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }

    static class addThread implements Runnable{
        @Override
        public void run(){
            for (int i = 0; i < 100; i++) {
                a ++;
            }

        }
    }
}
