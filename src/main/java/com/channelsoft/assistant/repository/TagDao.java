package com.channelsoft.assistant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.assistant.entity.Tag;

/**
 * 标签数据访问对象
 * 
 * @author tenanty
 *
 */
public interface TagDao extends PagingAndSortingRepository<Tag, Long> {

	/**
	 * 通过标签名查找标签信息
	 * 
	 * @param tagName
	 */
	public Tag findTagByTagName(String tagName);

}
