package com.cheng.thread.base.instance;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-27
 */
public class ThreadInstance extends Thread {

    public ThreadInstance(int name){
        this.setName(String.valueOf(name));
    }
    @Override
    public void run() {
        try {

            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + "thread run");
    }
}
