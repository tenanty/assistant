package com.channelsoft.assistant.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class HistoryInfoDaoTest {

	@Autowired
	private HistoryInfoDao historyInfoDao;

	@Test
	public void test() {
		// HistoryInfo history = new HistoryInfo();
		// CustInfo custInfo = new CustInfo();
		// custInfo.setCustId(new Long(1));
		// history.setRemark("ÁªÂçÀúÊ·001");
		// history.setCustInfo(custInfo);
		// historyInfoDao.save(history);
	}

}
