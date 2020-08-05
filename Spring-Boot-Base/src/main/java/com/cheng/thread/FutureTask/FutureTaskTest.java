package com.cheng.thread.FutureTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-15
 */
public class FutureTaskTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
       Integer all = 0;
        ArrayList<FutureTask<Integer>> ftList = new ArrayList<FutureTask<Integer>>();
        for (int i = 0; i < 100; i++) {
            FileSearchScan fileSearchScan = new FileSearchScan(new File(""),"12");
            FutureTask<Integer> ft = new FutureTask(fileSearchScan);
            threadPoolExecutor.submit(ft);
           ftList.add(ft);
        }
        for (int i = 0; i < ftList.size(); i++) {
            try {
                all += ftList.get(i).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println(all);


    }

    static class FileSearchScan implements Callable<Integer>{
        private  Integer count = 0;
        private String keyword;
        private File file;

        public FileSearchScan(File file,String keyword){
            this.file = file;
            this.keyword = keyword;
        }
        @Override
        public Integer call() throws Exception {

            boolean search = search(file);
            if (search) count ++;
            return count;
        }

        public boolean search(File file){
            boolean founded = false;
            try(Scanner scanner = new Scanner(new FileInputStream(file))){
                while(!founded && scanner.hasNextLine()){
                    if (scanner.nextLine().contains(keyword)){
                        founded = true;
                    }

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return  founded;
        }

    }
}
