package com.tiagodeveloper.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_event_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_history_generator")
	@SequenceGenerator(name="event_history_generator", sequenceName = "sq_event_history",allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	private String type;
	
	@ManyToOne(targetEntity = Subscription.class)
	@JoinColumn(name="subscription_id")
	private Subscription subscription;
	
	@Column(name="create_at")
	@CreationTimestamp
	private LocalDateTime createAt;
	
}
