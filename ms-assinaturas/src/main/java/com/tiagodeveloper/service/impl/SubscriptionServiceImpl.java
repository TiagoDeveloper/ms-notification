package com.tiagodeveloper.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiagodeveloper.domain.Status;
import com.tiagodeveloper.domain.Subscription;
import com.tiagodeveloper.dto.NotificationDTO;
import com.tiagodeveloper.dto.StatusDTO;
import com.tiagodeveloper.dto.SubscriptionDTO;
import com.tiagodeveloper.enums.TypeEnum;
import com.tiagodeveloper.event.CustomSpringEventPublisher;
import com.tiagodeveloper.repository.SubscriptionRepository;
import com.tiagodeveloper.service.NotificationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubscriptionServiceImpl implements NotificationService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private CustomSpringEventPublisher customSpringEventPublisher;
	
	@Override
	@Transactional
	public void createNotification(NotificationDTO dto) {
		final var subscription = saveSubscription(dto);
		customSpringEventPublisher.publishCustomEvent(convertEntityToDTO(subscription), dto);
	}

	public Subscription saveSubscription(NotificationDTO dto) {
		
		final var subscription = subscriptionRepository.findById(dto.getSubscription())
		.orElseGet(Subscription::new);
		
		subscription.setId(dto.getSubscription());
		
		if(Objects.nonNull(subscription.getStatus()))
			subscription.getStatus().setName(statusSubscription(dto.getNotificationType()));
		else
			subscription.setStatus(new Status(null, statusSubscription(dto.getNotificationType())));

		log.info("Salvando o subscription {}", subscription.getId());
		return subscriptionRepository.save(subscription);
	}
	
	private String statusSubscription(TypeEnum typeEnum) {
		if(typeEnum.equals(TypeEnum.SUBSCRIPTION_CANCELED))
			return "cancelada";
		else
			return	"ativa";
		 
	}
	
	private StatusDTO convertEntityToDTO(Status entity) {
		return StatusDTO.builder()
				.id(entity.getId())
				.name(entity.getName())
				.build();
	}
	private SubscriptionDTO convertEntityToDTO(Subscription entity) {
		return SubscriptionDTO.builder()
				.id(entity.getId())
				.status(convertEntityToDTO(entity.getStatus()))
				.createAt(entity.getCreateAt())
				.updateAt(entity.getUpdateAt())
				.build();
	}
	

}
