package com.cheng.config.event.core;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-24
 */
public interface EventHandler <T extends Event> {

    void handle(T event);
}
