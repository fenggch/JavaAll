package com.cheng.thread.base.instance;

import java.util.concurrent.Callable;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-27
 */
public class CallableInstance implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("callable run");

        try{
            System.out.println(2);
        }catch (Exception ex){

        } finally
        {
            System.out.println(1);
        }
        return "callable";
    }

    public static void main(String[] args) {
        System.out.println(s());
    }
    public static String s(){
        try{

         //   int i = 1/0;
            return "2";
        }catch (Exception ex){

        }finally {
            return "1";
        }

    }
}
