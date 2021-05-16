package com.tiagodeveloper.service.impl;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiagodeveloper.domain.EventHistory;
import com.tiagodeveloper.domain.Status;
import com.tiagodeveloper.domain.Subscription;
import com.tiagodeveloper.dto.NotificationDTO;
import com.tiagodeveloper.repository.EventHistoryRepository;
import com.tiagodeveloper.repository.SubscriptionRepository;
import com.tiagodeveloper.service.NotificationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;
	
	@Autowired
	private EventHistoryRepository eventHistoryRepository;
	
	@Override
	@Transactional
	public EventHistory createNotification(NotificationDTO dto) {
		
		final var subscription = saveSubscription(dto);
		return createEventHistory(subscription);
	}
	
	private Subscription saveSubscription(NotificationDTO dto) {
		
		final var subscription = subscriptionRepository.findById(dto.getSubscription())
		.orElseGet(Subscription::new);
		
		subscription.setId(dto.getSubscription());
		
		if(Objects.nonNull(subscription.getStatus())) {
			subscription.setUpdateAt(LocalDateTime.now());
			subscription.getStatus().setName(dto.getNotificationType());
		}else {
			subscription.setStatus(new Status(null, dto.getNotificationType()));
		}
		log.info("Salvando o subscription {}", subscription.getId());
		return subscriptionRepository.save(subscription);
	}
	
	private EventHistory createEventHistory(Subscription subscription) {
		final var eventHistory = new EventHistory();
		
		eventHistory.setSubscription(subscription);
		eventHistory.setType(subscription.getStatus().getName());
		eventHistoryRepository.save(eventHistory);
		
		return eventHistoryRepository.save(eventHistory);
	}

}
