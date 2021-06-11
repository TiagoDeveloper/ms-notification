package com.tiagodeveloper.event;

import org.springframework.context.ApplicationEvent;

import com.tiagodeveloper.dto.NotificationDTO;
import com.tiagodeveloper.dto.SubscriptionDTO;

import lombok.Getter;

@Getter
public class CustomSpringEvent<T> extends ApplicationEvent {
	private static final long serialVersionUID = 1L;

    private SubscriptionDTO subscriptionDTO;
    private NotificationDTO notificationDTO;

    public CustomSpringEvent(T source, SubscriptionDTO subscriptionDTO, NotificationDTO notificationDTO) {
        super(source);
        this.subscriptionDTO = subscriptionDTO;
        this.notificationDTO = notificationDTO;
    }
}
