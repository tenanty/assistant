package com.channelsoft.assistant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.assistant.controller.to.DatatablesResponse;
import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.entity.Tag;
import com.channelsoft.assistant.service.TagService;

@Controller
public class TagController {

	@Autowired
	private TagService tagService;

	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/tag", method = RequestMethod.GET)
	public String settingsTags() {
		logger.debug("进入 TagController.settingsTags()");
		return "business/tag";
	}

	@RequestMapping(value = "/getTag")
	@ResponseBody
	public DatatablesResponse<Tag> getAll() {
		logger.debug("进入 TagController.customer()");
		DatatablesResponse<Tag> response = new DatatablesResponse<Tag>();
		List<Tag> data = (List<Tag>) tagService.findAll();
		response.setData(data);
		return response;
	}

	@RequestMapping(value = "/tag", method = RequestMethod.POST)
	public void updateTag(@RequestParam("data[tagName]")String data,String action) {
		logger.debug("进入 TagController.updateTag()");
	}

	@RequestMapping(value = "/getCustomerByTag/{id:\\d+}", method = RequestMethod.GET)
	@ResponseBody
	public DatatablesResponse<Customer> getAll(@PathVariable("id") Long id) {
		logger.debug("进入 TagController.customer()");
		DatatablesResponse<Customer> response = new DatatablesResponse<Customer>();
		List<Customer> data = (List<Customer>) tagService
				.getCustomersByTagId(id);
		response.setData(data);
		return response;
	}
}
