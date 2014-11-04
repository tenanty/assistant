package com.channelsoft.assistant.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class PhoneInfoDaoTest {

	@Autowired
	private PhoneInfoDao phoneInfoDao;

	@Test
	public void testUpdatePhoneInfoDescById() {
		Integer result = phoneInfoDao.updatePhoneInfoDescById("移动电话1", new Long(1));
		System.out.println("result-testUpdatePhoneInfoDescById:" + result);
	}

	@Test
	public void testUpdatePhoneInfoNoById() {
		Integer result = phoneInfoDao.updatePhoneInfoNoById("13261870363", new Long(1));
		System.out.println("result-testUpdatePhoneInfoNoById:" + result);
	}

}
