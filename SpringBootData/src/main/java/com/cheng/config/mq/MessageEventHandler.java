package com.cheng.config.mq;

import com.cheng.config.event.core.EventHandler;
import com.cheng.config.event.events.MessageEvent;
import org.springframework.stereotype.Component;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-24
 */
@Component
public class MessageEventHandler implements EventHandler<MessageEvent> {
    @Override
    public void handle(MessageEvent event) {
        System.out.println("ojbk");
    }
}
