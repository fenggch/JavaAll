package com.cheng.thread.productorConsumer;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-28
 */
public class Test {
    private static Exchanger<String> exchanger = new Exchanger();
    public static void main(String[] args) {
//        // 仓库对象
//        AbstractStorage abstractStorage = new Storage1();
//
//        // 生产者对象
//        Producer p1 = new Producer(abstractStorage);
//        Producer p2 = new Producer(abstractStorage);
//        Producer p3 = new Producer(abstractStorage);
//        Producer p4 = new Producer(abstractStorage);
//        Producer p5 = new Producer(abstractStorage);
//        Producer p6 = new Producer(abstractStorage);
//        Producer p7 = new Producer(abstractStorage);
//
//        // 消费者对象
//        Consumer c1 = new Consumer(abstractStorage);
//        Consumer c2 = new Consumer(abstractStorage);
//        Consumer c3 = new Consumer(abstractStorage);
//
//        // 设置生产者产品生产数量
//        p1.setNum(10);
//        p2.setNum(10);
//        p3.setNum(10);
//        p4.setNum(10);
//        p5.setNum(10);
//        p6.setNum(10);
//        p7.setNum(80);
//
//        // 设置消费者产品消费数量
//        c1.setNum(50);
//        c2.setNum(20);
//        c3.setNum(30);
//
//        // 线程开始执行
//        c1.start();
//        c2.start();
//        c3.start();
//
//        p1.start();
//        p2.start();
//        p3.start();
//        p4.start();
//        p5.start();
//        p6.start();
//        p7.start();

        //代表男生和女生
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(() -> {
            try {
                System.out.println("女生慢慢的从教室你走出来......");
                TimeUnit.SECONDS.sleep(1);
                //男生对女生说的话
                String boy = exchanger.exchange("我也很喜欢你......");

                System.out.println("男孩儿说：" + boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.execute(() -> {
            try {
                //男生对女生说的话
                String girl = exchanger.exchange("我其实暗恋你很久了......");

                System.out.println("女孩儿说：" + girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.execute(() -> {
            try {
                //男生对女生说的话
                String girl = exchanger.exchange("我不同意......");

                System.out.println("第三说：" + girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        service.execute(() -> {
            try {
                //男生对女生说的话
                String girl = exchanger.exchange("我同意......");

                System.out.println("第4说：" + girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
