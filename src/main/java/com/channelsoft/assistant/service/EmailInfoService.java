package com.channelsoft.assistant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.assistant.repository.EmailInfoDao;

/**
 * �����ʼ�ҵ���߼�����
 * 
 * @author tenanty
 * 
 */
@Service
public class EmailInfoService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private EmailInfoDao emailInfoDao;

}
