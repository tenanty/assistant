package com.channelsoft.assistant.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.channelsoft.assistant.entity.Email;

public interface EmailInfoDao extends PagingAndSortingRepository<Email, Long> {

	/**
	 * 更新邮箱描述信息
	 * 
	 * @param emailDesc
	 * @param emailId
	 */
	@Transactional
	@Modifying
	@Query("update Email email set email.emailDesc = ?1 where email.emailId = ?2")
	public void updateEmailInfoDescById(String emailDesc, Long emailId);

	/**
	 * 更新邮箱地址信息
	 * 
	 * @param emailDesc
	 * @param emailId
	 */
	@Transactional
	@Modifying
	@Query("update Email email set email.emailAddress = ?1 where email.emailId = ?2")
	public void updateEmailInfoAddressById(String emailAddress, Long emailId);

}
