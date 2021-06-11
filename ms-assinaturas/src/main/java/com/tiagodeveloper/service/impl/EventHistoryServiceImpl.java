package com.tiagodeveloper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tiagodeveloper.domain.EventHistory;
import com.tiagodeveloper.event.CustomSpringEvent;
import com.tiagodeveloper.repository.EventHistoryRepository;
import com.tiagodeveloper.repository.SubscriptionRepository;
import com.tiagodeveloper.service.EventHistoryService;

@Service
public class EventHistoryServiceImpl implements EventHistoryService {
	
	@Autowired
	public EventHistoryRepository eventHistoryRepository;
	
	@Autowired
	public SubscriptionRepository subscriptionRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void registerEvent(CustomSpringEvent<?> event) {
		final var eventHistory = new EventHistory();
		var subscription = subscriptionRepository.getOne(event.getSubscriptionDTO().getId());
		eventHistory.setSubscription(subscription);
		eventHistory.setType(event.getNotificationDTO().getNotificationType());
		
		eventHistoryRepository.save(eventHistory);
	}
	
}