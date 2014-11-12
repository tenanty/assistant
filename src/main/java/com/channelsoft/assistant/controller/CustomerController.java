package com.channelsoft.assistant.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.assistant.controller.to.DatatablesResponse;
import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.entity.Email;
import com.channelsoft.assistant.entity.Phone;
import com.channelsoft.assistant.service.CustomerService;

/**
 * 客户资料控制层
 * 
 * @author tenanty
 *
 */
@Controller
public class CustomerController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private CustomerService customerService;

	/**
	 * 进入列表页面
	 * @return
	 */
	@RequestMapping(value = "/customer/list", method = RequestMethod.GET)
	public String list() {
		logger.debug("进入 CustomerController.customer()");
		return "business/customer";
	}

	/**
	 * 获取所有记录
	 * @return
	 */
	@RequestMapping(value = "/customer/all", method = RequestMethod.GET)
	@ResponseBody
	public DatatablesResponse<Customer> getAll() {
		logger.debug("进入 CustomerController.getAll()");
		DatatablesResponse<Customer> response = new DatatablesResponse<Customer>(
				DatatablesResponse.STATUS_SUCCESS, "查询成功");
		List<Customer> data = (List<Customer>) customerService.getAllCustomer();
		response.setData(data);
		return response;
	}

	/**
	 * 增加
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/customer",method = RequestMethod.POST)
	@ResponseBody
	public DatatablesResponse<Customer> add(Customer customer) {
		logger.debug("进入 CustomerController.add()");
		logger.debug("#customer=" + customer);
		DatatablesResponse<Customer> response = new DatatablesResponse<Customer>(
				DatatablesResponse.STATUS_SUCCESS, "添加成功");
		build(customer);
		customerService.save(customer);
		List<Customer> success = new ArrayList<Customer>();
		success.add(customer);
		response.setId(customer.getCustId());
		response.setData(success);
		
		return response;
	}

	/**
	 * 删除
	 * @param id
	 * @return
	 */
	// 使用restful类型的url进行设置
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public DatatablesResponse<Customer> delete(@PathVariable("id") Long id) {
		logger.debug("进入 CustomerController.delete()");
		DatatablesResponse<Customer> response = new DatatablesResponse<Customer>(
				DatatablesResponse.STATUS_SUCCESS, "删除成功");
		customerService.deleteCustomerById(id);
		return response;
	}
	
	/**
	 * 修改
	 * @param id
	 * @param customer
	 * @return
	 */
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public DatatablesResponse<Customer> update(@PathVariable("id") Long id,Customer customer){
		logger.debug("进入 CustomerController.update()");
		DatatablesResponse<Customer> response = new DatatablesResponse<Customer>(
				DatatablesResponse.STATUS_SUCCESS, "修改成功");
		return response;
	}

	/**
	 * 构建客户信息
	 * @param customer
	 */
	public void build(Customer customer) {

		// if (StringUtils.isNotBlank(customer.getTag())) {
		// String t = customer.getInputPhone();
		// Set<Tag> tset = new HashSet<Tag>();
		// String[] tags = t.split(",");
		// for (String tagName : tags) {
		// Tag tag = new Tag();
		// tag.setTagName(tagName);
		// tag.setCrateTime(new Date());
		// tset.add(new Tag(tagName, new Date()));
		// }
		// customer.setTags(tset);
		// }

		if (StringUtils.isNotBlank(customer.getInputEmail())) {
			String e = customer.getInputEmail();
			Set<Email> eset = new HashSet<Email>();
			String[] emails = e.split(",");
			for (String emailAddress : emails) {
				Email email = new Email();
				email.setEmailAddress(emailAddress);
				email.setCustomer(customer);
				eset.add(email);
			}
			customer.setEmails(eset);
		}

		if (StringUtils.isNotBlank(customer.getInputPhone())) {
			String p = customer.getInputPhone();
			Set<Phone> pset = new HashSet<Phone>();
			String[] phones = p.split(",");
			for (String phoneNo : phones) {
				Phone phone = new Phone();
				phone.setPhoneNo(phoneNo);
				phone.setCustInfo(customer);
				pset.add(phone);
			}
			customer.setPhones(pset);
		}

	}

}
