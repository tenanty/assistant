package com.channelsoft.assistant.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.assistant.controller.to.DatatablesResponse;
import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.entity.Email;
import com.channelsoft.assistant.entity.Phone;
import com.channelsoft.assistant.entity.Tag;
import com.channelsoft.assistant.service.CustomerService;

/**
 * 
 * @author tenanty
 *
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		logger.debug("进入 CustomerController.customer()");
		return "business/customer";
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public DatatablesResponse<Customer> getAll() {
		logger.debug("进入 CustomerController.getAll()");
		DatatablesResponse<Customer> response = new DatatablesResponse<Customer>(
				DatatablesResponse.STATUS_SUCCESS, "查询成功");
		List<Customer> data = (List<Customer>) customerService.getAllCustomer();
		response.setData(data);
		return response;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public DatatablesResponse<Customer> add(Customer customer) {
		logger.debug("进入 CustomerController.add()");
		logger.debug("#customer=" + customer);
		DatatablesResponse<Customer> response = new DatatablesResponse<Customer>(
				DatatablesResponse.STATUS_SUCCESS, "添加成功");
		build(customer);
		customerService.save(customer);
		return response;
	}
	
	public void build(Customer customer) {
		
		if (StringUtils.isNotBlank(customer.getTag())) {
			String t = customer.getInputPhone();
			Set<Tag> tset = new HashSet<Tag>();
			String[] tags = t.split(",");
			for (String tagName : tags) {
				Tag tag = new Tag();
				tag.setTagName(tagName);
				tag.setCrateTime(new Date());
				tset.add(new Tag(tagName, new Date()));
			}
			customer.setTags(tset);
		}
		
		if (StringUtils.isNotBlank(customer.getInputEmail())) {
			String e = customer.getInputEmail();
			Set<Email> eset = new HashSet<Email>();
			String[] emails = e.split(",");
			for (String emailAddress : emails) {
				Email email = new Email();
				email.setEmailAddress(emailAddress);
				email.setCustomer(customer);
				eset.add(email);
			}
			customer.setEmails(eset);
		}
		
		if (StringUtils.isNotBlank(customer.getInputPhone())) {
			String p = customer.getInputPhone();
			Set<Phone> pset = new HashSet<Phone>();
			String[] phones = p.split(",");
			for (String phoneNo : phones) {
				Phone phone = new Phone();
				
				pset.add(phone);
			}
			customer.setPhones(pset);
		}

	}

}
