package com.cheng.config.event.core;

import org.springframework.context.ApplicationEvent;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-24
 */
public class EventWapper extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public EventWapper(Object source) {
        super(source);
    }

    @Override
    public Event getSource() {
        return (Event)super.getSource();
    }
}
