package com.cheng.config.event.core;

import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.ResolvableType;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.http.codec.cbor.Jackson2CborEncoder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 事件监听器
 * 事件路由至对应handler执行
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-24
 */
@Component
public class EventListener implements ApplicationListener<EventWapper> {

    @Autowired
    List<EventHandler> handlers;

    @Override
    @Async
    public void onApplicationEvent(EventWapper event) {
        System.out.println(event.getSource().getEventType());

        final String sourceJson = JSONUtil.toJsonStr(event.getSource());//JSONObject.toJSONString(event.getSource());
      //  log.info("Spring事件中心收到事件 {}", sourceJson);
        for (EventHandler handler : handlers) {
//            Class<Event> clazz = handler.acceptEvent();
            Class<?> clazz = ResolvableType.forClass(handler.getClass()).as(EventHandler.class).getGeneric(0).resolve();
            if (clazz != null && clazz.getSimpleName().equals(event.getSource().getEventType())) {
                try {
                    handler.handle(event.getSource());
               //     log.info("Spring事件中心处理成功 handler={} source={}", handler.getClass().getName(), sourceJson);
                } catch (Throwable e) {
               //     log.error("Spring事件中心处理失败 handler={} source={}", handler.getClass().getName(), sourceJson, e);
                }
            }
        }
    }
}
