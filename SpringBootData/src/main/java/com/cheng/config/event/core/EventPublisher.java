package com.cheng.config.event.core;


import cn.hutool.json.JSONUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-24
 */
@Component
public class EventPublisher  {
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    RabbitTemplate rabbitTemplate;

    static ExecutorService threadPool =
            Executors.newFixedThreadPool(5);

    private static String mqEventPreSign = "rabbitMqMessage";
    /**
     * 发布事件
     *
     * @param events
     */
    public void publishEvent(Event... events) {
        for (Event event : events) {
            if (event == null) throw new RuntimeException("不允许发送空事件");
            final String json = JSONUtil.toJsonStr(event);
            String uuid = mqEventPreSign + "_" + UUID.randomUUID().toString();
           // log.info("rabbitMqSign {} 准备发送业务事件 {}", uuid, json);
            threadPool.execute(()->{
              //  log.info("rabbitMqSign {} start 发送业务事件",uuid);

                rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", "nihao");
                //rabbitTemplate.convertAndSend("directExchange",  null,"nihao");
            //    log.info("rabbitMqSign {} end 发送业务事件",uuid);
            });
        }
    }

    /**
     * 事务成功之后发送事件
     * 必须在开启Spring事务管理时（@Transactional标注的方法内）调用，否则将抛出异常
     *
     * @param events
     */
    public void publishEventAfterTransaction(Event... events) {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCompletion(int status) {
                super.afterCompletion(status);
                if (status == TransactionSynchronization.STATUS_COMMITTED) {
                    publishEvent(events);
                }
            }
        });
    }
}
