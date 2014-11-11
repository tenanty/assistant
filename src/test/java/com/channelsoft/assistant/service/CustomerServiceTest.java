package com.channelsoft.assistant.service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.service.spi.ServiceException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.entity.Email;
import com.channelsoft.assistant.entity.Tag;
import com.channelsoft.assistant.util.ObjectNotExistException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TagService tagService;

	@Test(expected = ObjectNotExistException.class)
	@Ignore
	public void testFindCustInfoByIdExist() {
		Customer custInfo = customerService.findCustInfoById(new Long(1));
		System.out.println(custInfo);
	}

	@Test(expected = ObjectNotExistException.class)
	public void testFindCustInfoByIdNotExist() {
		Customer custInfo = customerService.findCustInfoById(new Long(10000));
		System.out.println(custInfo);
	}

	@Test
	public void testDeleteCustInfoById() {
		Long custId = new Long(2);
		customerService.deleteCustInfoById(custId);
	}
	
	@Test
	@Ignore
	public void testSave(){
		Customer customer = new Customer();
		customer.setCustName("张三");
		Email email = new Email();
		email.setCustomer(customer);//之前遗漏了该方法进行对customer对象的设置，导致无法进行级联添加
		
		email.setEmailAddress("zs@channelosft.com");
		Set<Email> emails = new HashSet<Email>();
		emails.add(email);
		customer.setEmails(emails);
		customerService.save(customer);
		
	}
	
	@Test
	public void testAddCustomerWithTag(){
		Customer customer = new Customer();
		customer.setCustName("张三");
		
		Tag tag1 = new Tag();
		
		Set<Customer> custs = new HashSet<Customer>();
		custs.add(customer);
		
//		tag1 = tagService.findTagByTagName("标签3");
		tag1.setTagName("标签1");
		tag1.setCusts(custs);
		
		Tag tag2 = new Tag();
		tag2.setTagName("标签2");
		tag2.setCusts(custs);
		
		Set<Tag> tags = new HashSet<Tag>();
		tags.add(tag1);
		tags.add(tag2);
		
		customer.setTags(tags);
		customerService.save(customer);
	}

}
