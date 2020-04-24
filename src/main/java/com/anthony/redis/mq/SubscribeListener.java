package com.anthony.redis.mq;

import com.anthony.redis.template.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * <p>Description: </p>
 *
 * @author Anthony
 * @date 2020-04-22 4:53 PM
 */
public class SubscribeListener implements MessageListener {
    private static final Logger log = LoggerFactory.getLogger(RedisService.class);

    /**
     * Subscriptions receive messages from publishers
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // The cached message is serialized and needs to be deserialized. However, new String() can be deserialized, but static method valueOf() cannot.
        log.info(new String(pattern) + " Receive release:" + new String(message.getBody()));
    }
}