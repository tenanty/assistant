package com.channelsoft.assistant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.assistant.entity.Tag;

public interface TagDao extends PagingAndSortingRepository<Tag, Long> {
	
}
