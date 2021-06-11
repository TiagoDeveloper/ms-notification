package com.tiagodeveloper.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private StatusDTO status;
	
	private LocalDateTime createAt;
	
	private LocalDateTime updateAt;

}
