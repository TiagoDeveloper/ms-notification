package com.tiagodeveloper.component;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.tiagodeveloper.consumer.RabbitMQConsumer;
import com.tiagodeveloper.producer.RabbitMQProducer;

@Component
public class ComponentsApplication {

	@Value("${spring.rabbitmq.topic.name}")
	private String topic;
	
	@Bean
	public Queue notificationQueue() {
		return new Queue(topic, true);
	}
	
	@Bean
	public RabbitMQProducer rabbitMQProducer() {
		return new RabbitMQProducer();
	}
	
	@Bean
	public RabbitMQConsumer rabbitMQConsumer() {
		return new RabbitMQConsumer();
	}

}
