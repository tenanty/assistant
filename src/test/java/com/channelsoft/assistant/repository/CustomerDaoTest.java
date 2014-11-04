package com.channelsoft.assistant.repository;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.channelsoft.assistant.entity.Customer;
import com.channelsoft.assistant.entity.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class CustomerDaoTest {

	@Autowired
	private CustomerDao custInfoDao;

	@Test
	public void testCustInfoAdd() {
		Customer custInfo = new Customer();
		custInfo.setCustName("张三");
		custInfoDao.save(custInfo);
	}

	@Test
	public void testCustInfoDelete() {
		Customer custInfo = new Customer();
		custInfo.setCustName("张三");
		// custInfoDao.delete(custInfo);
	}

	@Test
	public void testDeleteCustNameByCustName() {
		// custInfoDao.deleteByCustName("张三");
	}

	@Test
	public void test() {
		List<Customer> custs = (List<Customer>) custInfoDao.findAll();
		for (Customer cust : custs) {
			Set<Tag> tags = cust.getTags();
//			for (TagInfo tag : tags) {
//				System.out.println(tag);
//			}
		}
	}

	// @Test
	// public void testFindCustInfo(){
	// List<CustInfo> list = custInfoDao.findByCustName("张三");
	// for(CustInfo cust:list){
	// System.out.println(cust);
	// }
	// List<CustInfo> list2 = custInfoDao.findAll(new Specification<CustInfo>()
	// {
	//
	// public Predicate toPredicate(Root<CustInfo> root, CriteriaQuery<?> query,
	// CriteriaBuilder cb) {
	//
	// return cb.createquery.equal(root.get( " custName " ), "张三" );
	// }
	// });
	// for(CustInfo custInfo:list2){
	// System.out.println(custInfo);
	// }
	// }

}
