package com.channelsoft.assistant.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.channelsoft.assistant.entity.Phone;

public interface PhoneInfoDao extends PagingAndSortingRepository<Phone, Long> {
	/**
	 * 更新电话描述
	 * 
	 * @param emailDesc
	 * @param emailId
	 */
	@Transactional
	@Modifying
	@Query("update Phone phone set phone.phoneDesc = :phoneDesc where phone.phoneId = :phoneId")
	public Integer updatePhoneInfoDescById(@Param("phoneDesc") String phoneDesc, @Param("phoneId") Long phoneId);

	/**
	 * 更新电话号码
	 * 
	 * @param emailDesc
	 * @param emailId
	 */
	@Transactional
	@Modifying
	@Query("update Phone phone set phone.phoneNo = ?1 where phone.phoneId = ?2")
	public Integer updatePhoneInfoNoById(String phoneDesc, Long phoneId);
}
