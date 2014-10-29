package com.channelsoft.assistant.service;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.entity.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TagServiceTest {

	@Autowired
	private TagService tagService;

	@Test
	public void testSaveTag() {
		Tag tag = new Tag();
		tag.setCrateTime(new Date());
		tag.setTagName("简单标签");
		tag = tagService.saveTag(tag);
		Assert.assertEquals("简单标签", tag.getTagName());
	}

	@Test
	public void testGetCustomersByTagId() {
		List<Customer> list = tagService.getCustomersByTagId(new Long(1));
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

}
