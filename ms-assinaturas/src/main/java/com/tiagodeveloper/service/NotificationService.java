package com.tiagodeveloper.service;

import com.tiagodeveloper.domain.EventHistory;
import com.tiagodeveloper.dto.NotificationDTO;


public interface NotificationService {

	EventHistory createNotification(NotificationDTO notificationDTO);

}
