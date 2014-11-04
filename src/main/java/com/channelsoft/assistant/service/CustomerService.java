package com.channelsoft.assistant.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.repository.CustomerDao;
import com.channelsoft.assistant.util.ObjectNotExistException;

/**
 * 客户信息业务逻辑对象
 * 
 * @author tenanty
 * 
 */
@Service
public class CustomerService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomerDao customerDao;
	
	/**
	 * 获取所有客户资料
	 * @return
	 */
	public Iterable<Customer> getAllCustomer(){
		logger.debug("进入 CustInfoService.findCustInfoById()");
		return customerDao.findAll();
	}

	/**
	 * 通过OID获取客户信息
	 * 
	 * @param custId
	 * @return
	 */
	public Customer findCustInfoById(Long custId) {
		logger.debug("进入 CustInfoService.findCustInfoById()");
		Customer custInfo = customerDao.findOne(custId);
		if (custInfo == null) {
			throw new ObjectNotExistException("客户信息");
		}
		return custInfo;
	}

	/**
	 * 删除指定编号的客户信息
	 * 
	 * @return
	 */
	public void deleteCustInfoById(Long custId) {
		logger.debug("进入 CustInfoService.deleteCustInfoById()");
		Customer custInfo = new Customer();
		custInfo.setCustId(custId);
		customerDao.delete(custInfo);
	}
	
	public List<Customer> findAll(){
		logger.debug("进入 CustInfoService.findAll()");
		return (List<Customer>) customerDao.findAll();
	}
	
}
