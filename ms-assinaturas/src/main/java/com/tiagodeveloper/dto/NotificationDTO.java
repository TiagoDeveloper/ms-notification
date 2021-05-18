package com.tiagodeveloper.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class NotificationDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotBlank(message = "notification_type não pode ser vazio ou nulo")
	@JsonProperty("notification_type")
	private String notificationType;
	@NotBlank(message = "subscription não pode ser vazio ou nulo")
	private String subscription;

}
