package com.channelsoft.assistant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.assistant.controller.to.DatatablesResponse;
import com.channelsoft.assistant.entity.Customer;
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
		customerService.save(customer);
		return response;
	}

}
