package com.channelsoft.assistant.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.assistant.entity.Account;

/**
 * 账户信息数据访问对象
 * @author tenanty
 *
 */
public interface AccountDao extends PagingAndSortingRepository<Account, Long> {

	Account findAccountByAccount(String username);

}
