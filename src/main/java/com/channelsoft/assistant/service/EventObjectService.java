package com.channelsoft.assistant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.assistant.repository.EventObjectDao;

/**
 * 事件对象业务访问逻辑
 * 
 * @author tenanty
 *
 */
@Service
public class EventObjectService {
	@Autowired
	private EventObjectDao eventObjectDao;

}
