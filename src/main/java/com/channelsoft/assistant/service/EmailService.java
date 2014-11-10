package com.channelsoft.assistant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.assistant.entity.Email;
import com.channelsoft.assistant.repository.EmailDao;

/**
 * 电子邮件业务逻辑对象
 * 
 * @author tenanty
 * 
 */
@Service
public class EmailService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EmailDao emailInfoDao;

	public Email save(Email email) {
		logger.debug("进入 EmailService.save()");
		return emailInfoDao.save(email);
	}

}
