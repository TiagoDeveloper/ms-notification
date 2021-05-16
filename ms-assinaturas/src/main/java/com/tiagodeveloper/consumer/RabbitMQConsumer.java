package com.tiagodeveloper.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;

import com.tiagodeveloper.dto.NotificationDTO;
import com.tiagodeveloper.service.NotificationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RabbitMQConsumer {
	
	@Autowired
	private NotificationService notificationService;
	
	@RabbitListener(queues = "${spring.rabbitmq.topic.name}")
	public void receive(@Payload NotificationDTO notification) {
		
		try {
			notificationService.createNotification(notification);
		} catch (Exception  e) {
			log.error("Erro ao consumir o message do rabbitMQ");
		}
		
	}

}
