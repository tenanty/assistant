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
		logger.debug("进入 TagService.saveTag()方法.");
		return tagDao.save(tag);
	}

	public List<Tag> findAll() {
		logger.debug("进入 TagService.findAll()方法.");
		return (List<Tag>) tagDao.findAll();
	}

	/**
	 * 根据标签编号获取对应的客户信息集合
	 * 
	 * @param tagId
	 * @return
	 */
	public List<Customer> getCustomersByTagId(Long tagId) {
		logger.debug("进入 CustInfoService.getCustomersByTagId()");
		Tag tag = tagDao.findOne(tagId);
		List<Customer> list = new ArrayList<Customer>();
		// list.addAll(tag.getCusts());
		return list;
	}

	/**
	 * 根据标签名获取标签对象
	 * 
	 * @param tagName
	 * @return
	 */
	public Tag findTagByTagName(String tagName) {
		logger.debug("进入 CustInfoService.findTagByTagName()");
		return tagDao.findTagByTagName(tagName);
	}

}
