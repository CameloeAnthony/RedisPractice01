package com.anthony.redis.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>Description: </p>
 *
 * @author Anthony
 * @date 2020-04-22 4:54 PM
 */
@Component
public class PublishService {
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * Publishing method
     * @param channel Message publishing subscription topic
     * @param message Message information
     */
    public void publish(String channel, Object message) {
        // connection.publish(rawChannel, rawMessage) encapsulated by this method;
        redisTemplate.convertAndSend(channel, message);
    }
}