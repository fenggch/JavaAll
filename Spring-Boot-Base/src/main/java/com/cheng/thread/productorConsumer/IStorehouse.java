package com.cheng.thread.productorConsumer;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-28
 */
public interface IStorehouse {
    void product(int num);
    void consumer(int num);
}
