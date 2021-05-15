package com.tiagodeveloper.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitMQProducer {

	@Autowired
	private Queue notificationQueue;
	
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    public void send(String notification) {
        rabbitTemplate.convertAndSend(notificationQueue.getName(), notification);
    }
}
