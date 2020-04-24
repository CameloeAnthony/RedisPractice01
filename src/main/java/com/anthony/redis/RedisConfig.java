package com.anthony.redis;

import com.anthony.redis.mq.SubscribeListener;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * <p>Description: </p>
 *
 * @author Anthony
 * @date 2020-04-22 3:35 PM
 */
@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {


    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(redisConnectionFactory);
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer(); //custom
//        RedisObjectSerializer redisObjectSerializer = new RedisObjectSerializer();
//        template.setKeySerializer(stringRedisSerializer);
//        template.setValueSerializer(redisObjectSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }


    //Configure listening test topic topic topic in RedisConfig
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        // Add subscriber listening classes. The number is unlimited. PatternTopic defines listening topics. Here, listening to test topic topics
        container.addMessageListener(new SubscribeListener(), new PatternTopic("test-topic"));
        return container;
    }
}