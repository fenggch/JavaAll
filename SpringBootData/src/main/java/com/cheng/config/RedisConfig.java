package com.cheng.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Arrays;
import java.util.Set;

/**
 * class functional description
 *
 * @author Feng GuiCheng
 * @version 1.0.0
 * @since 2020-06-22
 */
@EnableCaching
@Component
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * 把任何数据保存到redis时，都需要进行序列化，默认使用JdkSerializationRedisSerializer进行序列化。
     * 默认的序列化会给所有的key,value的原始字符前，都加了一串字符（例如：\xAC\xED\x00\），不具备可读性
     * 所以需要配置jackson序列化方式
     */
//    @Bean
//    @ConditionalOnMissingBean(name = "redisTemplate")
//    public RedisTemplate<Object, Object> redisTemplate(
//            RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        //使用jackson序列化
//        Jackson2JsonRedisSerializer fastJsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        // value值的序列化采用fastJsonRedisSerializer
//
//        template.setValueSerializer(fastJsonRedisSerializer);
//
//        template.setHashValueSerializer(fastJsonRedisSerializer);
//        // key的序列化采用StringRedisSerializer
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }

//      @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//        return rcm;
//    }
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        FormattingConversionService formattingConversionService = new FormattingConversionService();

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .withConversionService(formattingConversionService)
                .prefixKeysWith("teach:daily")
                .entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
//        RedisCacheConfiguration redisCacheConfiguration2 = RedisCacheConfiguration
//                .defaultCacheConfig()
//                .withConversionService(new DefaultConversionService())
//                .prefixKeysWith("NIHAO2:")
//                .entryTtl(Duration.ofHours(1));
        RedisCacheManager build = RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
//                .withCacheConfiguration("nihao2",redisCacheConfiguration2)

                .cacheDefaults(redisCacheConfiguration).build();
        return build;
    }
//
    /**
     * 把任何数据保存到redis时，都需要进行序列化，默认使用JdkSerializationRedisSerializer进行序列化。
     * 默认的序列化会给所有的key,value的原始字符前，都加了一串字符（例如：\xAC\xED\x00\），不具备可读性
     * 所以需要配置jackson序列化方式
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(factory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.registerModule(new SimpleModule().addSerializer(new NullValueSerializer(null)));
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
    //    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.WRAPPER_ARRAY
        );


        jacksonSeial.setObjectMapper(om);

        JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();

        // 值采用json序列化
        template.setValueSerializer(new StringRedisSerializer());
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());

        // 设置hash key 和value序列化模式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();

        return template;
    }

//    @Bean
//    public KeyGenerator keyGenerator() {
//        return (target, method, params) -> keyGeneratorImpl(target.getClass().getName());
//    }



    private KeyGenerator keyGeneratorImpl(String prefix){
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(prefix);
            sb.append(method.getName());
            if(params != null && params.length > 0) {
                sb.append("(");
                sb.append(Arrays.stream(params).map(item -> item != null ? item.toString() : null).reduce((i1, i2) -> i1 + "," + i2).get());
                sb.append(")");
            }
            return sb.toString();
        };
    }
//
//    @Bean
//    @ConditionalOnMissingBean(StringRedisTemplate.class)
//    public StringRedisTemplate stringRedisTemplate(
//            RedisConnectionFactory redisConnectionFactory) {
//        StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }
}
