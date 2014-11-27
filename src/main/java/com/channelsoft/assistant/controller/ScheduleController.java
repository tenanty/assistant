package com.channelsoft.assistant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.channelsoft.assistant.service.EventObjectService;

/**
 * 日志信息控制类
 * 
 * @author tenanty
 *
 */
@Controller
@RequestMapping(value = "/schedule")
public class ScheduleController {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EventObjectService eventObjectService;

	/**
	 * 进入页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		logger.debug("进入 ScheduleController.list()");
		return "business/schedule";
	}

}
