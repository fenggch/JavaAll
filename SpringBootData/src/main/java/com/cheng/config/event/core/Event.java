package com.cheng.config.event.core;

import java.io.Serializable;

/**
 * class functional description
 *  自定义事件，集成ApplicationEvent。
 * 定义事件监听器，实现ApplicationListener。
 * 使用容器发布事件。
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-24
 */
public interface Event extends Serializable {
    /**
     * 事件类型取Simple类名
     * @return
     */
    default String getEventType() {
        return this.getClass().getSimpleName();
    }
}
