package com.tiagodeveloper;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiagodeveloper.dto.NotificationDTO;
import com.tiagodeveloper.service.NotificationService;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private NotificationService notificationService;
	
	@Test
	void createNotificationTest() throws Exception {
		
		final NotificationDTO dto = new NotificationDTO();
			dto.setNotificationType("SUBSCRIPTION_PURCHASED");
			dto.setSubscription("5793cf6b3fd833521db8c420955e6f01");
		
		mockMvc.perform(post("/notification")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(dto)))
		.andExpect(status().isOk());
		
		verify(notificationService, times(1)).createNotification(dto);
		
	}

}
