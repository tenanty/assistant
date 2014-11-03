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

@Controller
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String customer() {
		logger.debug("进入 CustomerController.customer()");
		return "business/customer";
	}

	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET)
	@ResponseBody
	public DatatablesResponse<Customer> getAll() {
		logger.debug("进入 CustomerController.customer()");
		DatatablesResponse<Customer> response = new DatatablesResponse<Customer>();
		List<Customer> data = (List<Customer>) customerService.getAllCustomer();
		response.setData(data);
		return response;
	}

}
