package com.tiagodeveloper.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatusDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;
	
}
