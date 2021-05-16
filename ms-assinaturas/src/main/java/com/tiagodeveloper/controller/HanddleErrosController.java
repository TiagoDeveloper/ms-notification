package com.tiagodeveloper.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.tiagodeveloper.service.exception.QueueProducerException;

@RestControllerAdvice
public class HanddleErrosController {
	
	@ExceptionHandler(value = {QueueProducerException.class})
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Map<String, Object>> handdleErro500(QueueProducerException ex, WebRequest request){
		final Map<String, Object> map = new HashMap<>();
			map.put("timestamp", new Date());
			map.put("status", ex.getHttpStatus());
			map.put("message", ex.getMessage());
			map.put("path", ((ServletWebRequest)request).getRequest().getRequestURI());
		return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
