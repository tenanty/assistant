package com.channelsoft.assistant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.assistant.entity.Account;

public interface AccountDao extends PagingAndSortingRepository<Account, Long> {

	Account findAccountByAccount(String username);

}
