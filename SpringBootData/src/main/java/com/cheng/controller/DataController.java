package com.cheng.controller;

import org.assertj.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-22
 */
@RestController
@RequestMapping("data")
public class DataController {

    private static final Logger LOG = LoggerFactory.getLogger(DataController.class);

    @Autowired
    private RedisTemplate redisTemplate;
    @PostMapping("set")
    @ResponseBody
    public Object setData(@RequestBody Map<String,String> data){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        data.forEach((k,v)->{
            valueOperations.set(k,v);
        });


        return "";
    }

    @GetMapping("get")
    @ResponseBody
    public Object getData(String key){
        LOG.info("INFO");
        LOG.debug("debug");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    @GetMapping("get1")
    @ResponseBody
    @Cacheable(value = "teach:daily",keyGenerator = "simpleKeyBenerator")
    public Object getData1(String key){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        return valueOperations.get(key);
        return DateUtil.now().getTime();
    }

    @GetMapping("get2")
    @ResponseBody
    public Object getData2(String key){
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//        return valueOperations.get(key);
        return DateUtil.now().getTime();
    }
}
