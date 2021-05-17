package com.tiagodeveloper.component;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.tiagodeveloper.consumer.RabbitMQConsumer;
import com.tiagodeveloper.producer.RabbitMQProducer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

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
	
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)
	      .select()
	      .apis(RequestHandlerSelectors.basePackage("com.tiagodeveloper.controller"))
	      .build();
	}

}
