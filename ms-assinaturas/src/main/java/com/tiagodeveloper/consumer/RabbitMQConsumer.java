package com.tiagodeveloper.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RabbitMQConsumer {

	
	@RabbitListener(queues = "${spring.rabbitmq.topic.name}")
	public void receive(@Payload String notification) {
		log.info("notification: "+ notification);
	}

}
