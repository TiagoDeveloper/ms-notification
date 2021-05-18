package com.tiagodeveloper.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NotificationDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("notification_type")
	private String notificationType;
	private String subscription;

}
