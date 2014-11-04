package com.channelsoft.assistant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/schedule")
public class ScheduleController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(method = RequestMethod.GET)
	public String schedule() {
		logger.debug("进入 ScheduleController.schedule()");
		return "business/schedule";
	}
}
