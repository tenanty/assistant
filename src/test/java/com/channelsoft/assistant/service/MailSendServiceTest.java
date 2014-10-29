package com.channelsoft.assistant.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MailSendServiceTest {

	@Autowired
	private MailSendService mailSendService;

	public void testSendSimpleMail() {
		mailSendService.sendSimpleMail("1", "1");
	}

	@Test
	public void testA() {
		// mailSendService.sendMimeMail();
	}
}
