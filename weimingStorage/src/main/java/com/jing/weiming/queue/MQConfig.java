package com.jing.weiming.queue;

/**
 * @author jing
 * @create 2020-03-28-9:47
 */
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Bean
    public Queue queueStorage(){
        return new Queue("storage_queue", true);
    }
}
