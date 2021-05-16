package com.tiagodeveloper.domain;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_subscription")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
	
	@Id
	private String id;
	
	@OneToOne(targetEntity = Status.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "status_id")
	private Status status;
	
	@Column(name = "create_at")
	@CreationTimestamp
	private LocalDateTime createAt;
	
	@Column(name = "update_at")
	@UpdateTimestamp
	private LocalDateTime updateAt;

}
