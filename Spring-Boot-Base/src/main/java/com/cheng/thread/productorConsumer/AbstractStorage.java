package com.cheng.thread.productorConsumer;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-05-28
 */
public interface AbstractStorage {
    void consume(int num);
    void produce(int num);
}