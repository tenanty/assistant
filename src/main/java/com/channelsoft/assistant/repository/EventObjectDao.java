package com.channelsoft.assistant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.assistant.entity.EventObject;

/**
 * 事件对象数据访问层
 * 
 * @author tenanty
 *
 */
public interface EventObjectDao extends PagingAndSortingRepository<EventObject, Long> {
	
}
