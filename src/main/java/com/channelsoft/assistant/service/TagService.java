package com.channelsoft.assistant.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.entity.Tag;
import com.channelsoft.assistant.repository.TagDao;

@Service
public class TagService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TagDao tagDao;

	public Tag saveTag(Tag tag) {
		logger.debug("���� TagService.saveTag()����.");
		return tagDao.save(tag);
	}

	public List<Tag> findAll() {
		logger.debug("���� TagService.findAll()����.");
		return (List<Tag>) tagDao.findAll();
	}

	/**
	 * ���ݱ�ǩ��Ż�ȡ��Ӧ�Ŀͻ���Ϣ����
	 * 
	 * @param tagId
	 * @return
	 */
	public List<Customer> getCustomersByTagId(Long tagId) {
		logger.debug("���� CustInfoService.getCustomersByTagId()");
		Tag tag = tagDao.findOne(tagId);
		List<Customer> list = new ArrayList<Customer>();
		list.addAll(tag.getCusts());
		return list;
	}

}
