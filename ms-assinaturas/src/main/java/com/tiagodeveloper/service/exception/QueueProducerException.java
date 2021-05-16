package com.tiagodeveloper.service.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class QueueProducerException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final HttpStatus httpStatus;
	private final String message;
	
	public QueueProducerException(final String message) {
		super(message);
		this.message = message;
		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		
	}

}
