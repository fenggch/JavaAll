package com.cheng.thread.base.instance;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-27
 */
public class InstanceTest {

    public static void main(String[] args) {
//        ThreadInstance threadInstance = new ThreadInstance();
//        threadInstance.start();
//
//        Thread thread = new Thread(new RunnableInstance());
//        thread.start();
//
//        FutureTask<String> futureTask = new FutureTask(new CallableInstance());
//        Thread thread1 = new Thread(futureTask);
//        thread1.start();
//        try {
//            String s = futureTask.get();
//            System.out.println(s);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(new ThreadInstance());
//        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            executorService.execute(new ThreadInstance(i));
        }
        executorService.shutdown();
      //  new ScheduledThreadPoolExecutor

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        MyRunnable runnableTest = new MyRunnable();
//        for (int i = 0; i < 5; i++) {
//            executorService.execute(runnableTest);
//        }
//
//        System.out.println("线程任务开始执行");
//        executorService.shutdown();

    }
}
