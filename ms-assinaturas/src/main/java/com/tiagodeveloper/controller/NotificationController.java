package com.tiagodeveloper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagodeveloper.dto.NotificationDTO;
import com.tiagodeveloper.producer.RabbitMQProducer;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private RabbitMQProducer rabbitMQProducer;
	
	@PostMapping
	@ApiOperation(value = "Endpoint para envio da notificação para fila do RabbitMQ")
	public ResponseEntity<Void> createNotification(@RequestBody NotificationDTO notificationDTO) {
		
		rabbitMQProducer.send(notificationDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
