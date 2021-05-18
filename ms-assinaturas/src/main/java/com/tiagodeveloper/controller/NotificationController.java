package com.tiagodeveloper.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagodeveloper.dto.NotificationDTO;
import com.tiagodeveloper.producer.RabbitMQProducer;
import com.tiagodeveloper.service.exception.QueueProducerException;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private RabbitMQProducer rabbitMQProducer;
	
	@PostMapping
	@ApiOperation(value = "Endpoint para envio da notificação para fila do RabbitMQ")
	public ResponseEntity<Void> createNotification(@Valid @RequestBody NotificationDTO notificationDTO, BindingResult result) {
		
		if(result.hasErrors()) {
			String error = result.getAllErrors().stream()
					.map(DefaultMessageSourceResolvable::getDefaultMessage)
					.collect(Collectors.joining(","));
			log.error(error);
			throw new QueueProducerException(error);
		}
		
		rabbitMQProducer.send(notificationDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
