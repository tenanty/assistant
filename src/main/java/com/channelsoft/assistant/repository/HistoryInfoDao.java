package com.channelsoft.assistant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.assistant.entity.History;

public interface HistoryInfoDao extends PagingAndSortingRepository<History, Long> {

}
