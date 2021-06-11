package com.tiagodeveloper.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import com.tiagodeveloper.dto.NotificationDTO;
import com.tiagodeveloper.dto.SubscriptionDTO;
import com.tiagodeveloper.service.EventHistoryService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomSpringEventPublisher {
    
	@Autowired
    private ApplicationEventPublisher applicationEventPublisher;
	
    @Autowired
	private EventHistoryService eventHistoryService;

    public void publishCustomEvent(final SubscriptionDTO subscriptionDTO, NotificationDTO notificationDTO) {
        var customSpringEvent = new CustomSpringEvent<CustomSpringEventPublisher>(this, subscriptionDTO, notificationDTO);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }
    
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void registerEvent(CustomSpringEvent<CustomSpringEventPublisher> event) {
        log.info("Registrando o evento AFTER_COMMIT.");
        eventHistoryService.registerEvent(event);
    }
}