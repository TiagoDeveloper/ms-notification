package com.tiagodeveloper.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.tiagodeveloper.dto.NotificationDTO;
import com.tiagodeveloper.service.exception.QueueProducerException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RabbitMQProducer {

	@Autowired
	private Queue notificationQueue;
	
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    public void send(NotificationDTO notification) {
    	
		try {
			rabbitTemplate.convertAndSend(notificationQueue.getName(), notification);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new QueueProducerException("Erro ao enviar a mensagem para o RabbitMQ.");
		}
    }
}
