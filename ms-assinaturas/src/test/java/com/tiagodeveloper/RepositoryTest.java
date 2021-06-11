package com.tiagodeveloper;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.tiagodeveloper.domain.EventHistory;
import com.tiagodeveloper.domain.Status;
import com.tiagodeveloper.domain.Subscription;
import com.tiagodeveloper.enums.TypeEnum;
import com.tiagodeveloper.repository.EventHistoryRepository;
import com.tiagodeveloper.repository.SubscriptionRepository;

@DataJpaTest
@ActiveProfiles("test")
class RepositoryTest {
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private EventHistoryRepository eventHistoryRepository;
	
	@Test
	void saveSubscriptionTest() {
		final Subscription subscription = new Subscription();
		subscription.setId("5793cf6b3fd833521db8c420955e6f06");
		final Status status = new Status(null, "ativo");
		subscription.setStatus(status);
		
		final Subscription expect = subscriptionRepository.save(subscription);
		
		assertNotNull(expect.getStatus().getId());
	}
	
	@Test
	@Sql("classpath:scripts/test/create-subscription.sql")
	void saveEventHistoryTest() {
		final EventHistory eventHistory = new EventHistory();
		
		final Subscription subscription = subscriptionRepository.findById("5793cf6b3fd833521db8c420955e6f06")
				.orElseThrow(RuntimeException::new);
		
		eventHistory.setSubscription(subscription);
		eventHistory.setType(TypeEnum.SUBSCRIPTION_PURCHASED);
		
		final EventHistory expect = eventHistoryRepository.save(eventHistory);
		
		assertNotNull(expect.getId());
	}

}
