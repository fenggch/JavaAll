package com.cheng.controller;

import com.cheng.config.event.core.EventPublisher;
import com.cheng.config.event.events.MessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-24
 */
@RestController
@RequestMapping("rabbit")
public class RabbitControlelr {

    @Autowired
    EventPublisher eventPublisher;

    @PostMapping("send")
    public void send(){
        eventPublisher.publishEvent(new MessageEvent());
    }
}
