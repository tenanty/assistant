package com.channelsoft.assistant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.repository.CustomerDao;
import com.channelsoft.assistant.util.ObjectNotExistException;

/**
 * �ͻ���Ϣҵ���߼�����
 * 
 * @author tenanty
 * 
 */
@Service
public class CustomerService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomerDao custInfoDao;
	
	/**
	 * ��ȡ���пͻ�����
	 * @return
	 */
	public Iterable<Customer> getAllCustomer(){
		logger.debug("���� CustInfoService.findCustInfoById()");
		return custInfoDao.findAll();
	}

	/**
	 * ͨ��OID��ȡ�ͻ���Ϣ
	 * 
	 * @param custId
	 * @return
	 */
	public Customer findCustInfoById(Long custId) {
		logger.debug("���� CustInfoService.findCustInfoById()");
		Customer custInfo = custInfoDao.findOne(custId);
		if (custInfo == null) {
			throw new ObjectNotExistException("�ͻ���Ϣ");
		}
		return custInfo;
	}

	/**
	 * ɾ��ָ����ŵĿͻ���Ϣ
	 * 
	 * @return
	 */
	public void deleteCustInfoById(Long custId) {
		logger.debug("���� CustInfoService.deleteCustInfoById()");
		Customer custInfo = new Customer();
		custInfo.setCustId(custId);
		custInfoDao.delete(custInfo);
	}
	
}
