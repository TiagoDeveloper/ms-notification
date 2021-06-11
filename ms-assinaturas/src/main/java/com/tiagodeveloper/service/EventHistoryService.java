package com.tiagodeveloper.service;

import com.tiagodeveloper.event.CustomSpringEvent;

public interface EventHistoryService {
	
	 void registerEvent(CustomSpringEvent<?> event);

}
