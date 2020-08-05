package com.cheng.thread.lock;

import com.cheng.thread.base.instance.ThreadInstance;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-27
 */
public class ReentrantLockTest {
    static Lock lock = new ReentrantLock(true);
    public static void main(String[] args) {

        for (int i = 0; i <5 ; i++) {
            Thread thread = new Thread(new ThreadDemo(i));
            thread.start();

        }
    }

    static class ThreadDemo extends Thread{
        public ThreadDemo(int i){
            this.setName(String.valueOf(i));
        }
        @Override
        public void run() {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i=0;i<20;i++){
                lock.lock();
                System.out.println("获得锁的线程："+this.getName());
                lock.unlock();

            }

        }
    }
}
