package com.tiagodeveloper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_generator")
	@SequenceGenerator(name="status_generator", sequenceName = "sq_status",allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	private String name;
	
}
