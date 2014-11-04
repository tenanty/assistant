package com.channelsoft.assistant.repository;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.entity.Email;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class EmailInfoDaoTest {

	@Autowired
	private EmailInfoDao emailInfoDao;

	@Autowired
	private CustomerDao custInfoDao;

	@Before
	public void validateEmailInfoExist() {
		// 初始化测试数据

		boolean exist = emailInfoDao.exists(new Long(1));
		boolean custExist = custInfoDao.exists(new Long(14));
		System.out.println("exist:" + exist + "|custExist:" + custExist);
		if (!custExist) {
			Customer custInfo = new Customer();
			custInfo.setCustId(new Long(14));
			custInfoDao.save(custInfo);
		}

		if (!exist) {
			Email emailInfo = new Email();
			Customer custInfo = new Customer();
			custInfo.setCustId(new Long(14));
			emailInfo.setEmailId(new Long(1));
			emailInfo.setCustInfo(custInfo);
			emailInfoDao.save(emailInfo);
		}
	}

	@Test
	@Ignore
	public void testUpdateEmailInfoDescById() {
		emailInfoDao.updateEmailInfoDescById("工作1", new Long(1));
	}

	@Test
	@Ignore
	public void testUpdateEmailInfoAddressById() {
		if (!emailInfoDao.exists(new Long(1))) {
			if (!custInfoDao.exists(new Long(1))) {
				custInfoDao.save(new Customer(new Long(1), "1", "2", "3", "4",
						"5", "6"));
			}
			emailInfoDao.save(new Email(new Long(1), "1", "2", new Customer(
					new Long(1), "1", "2", "3", "4", "5", "6")));
		}
		emailInfoDao.updateEmailInfoAddressById("yuanshun1@channelsoft.com",
				new Long(1));
	}

	@Test
	@Ignore
	public void testSaveEmailInfo() {

		Email email = new Email();
		email.setEmailDesc("公司邮件");
		email.setEmailAddress("yuanshun@channelsoft.com");
		Customer custInfo = new Customer();
		custInfo.setCustId(new Long(4));
		email.setCustInfo(custInfo);
		emailInfoDao.save(email);
	}
}
