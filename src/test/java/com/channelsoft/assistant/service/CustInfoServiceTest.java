package com.channelsoft.assistant.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.util.ObjectNotExistException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CustInfoServiceTest {

	@Autowired
	private CustomerService custInfoService;

	@Test(expected = ObjectNotExistException.class)
	@Ignore
	public void testFindCustInfoByIdExist() {
		Customer custInfo = custInfoService.findCustInfoById(new Long(1));
		System.out.println(custInfo);
	}

	@Test(expected = ObjectNotExistException.class)
	public void testFindCustInfoByIdNotExist() {
		Customer custInfo = custInfoService.findCustInfoById(new Long(10000));
		System.out.println(custInfo);
	}

	@Test
	public void testDeleteCustInfoById() {
		Long custId = new Long(2);
		custInfoService.deleteCustInfoById(custId);
	}

}
