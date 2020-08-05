package com.cheng.config.event.events;

import com.cheng.config.event.core.Event;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-24
 */

public class MessageEvent implements Event {
    private String messageId;
    private String body;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
