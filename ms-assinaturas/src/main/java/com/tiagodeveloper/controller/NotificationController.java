package com.tiagodeveloper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagodeveloper.dto.NotificationDTO;
import com.tiagodeveloper.service.NotificationService;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
	
	@PostMapping
	public ResponseEntity<Void> createNotification(@RequestBody NotificationDTO notificationDTO) {
		
		notificationService.createNotification(notificationDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
