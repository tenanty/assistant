package com.channelsoft.assistant.repository;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.channelsoft.assistant.entity.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TagDaoTest {

	@Autowired
	private TagDao tagDao;

	@Test
	public void testSaveTag() {

		for (int i = 0; i < 100; i++) {
			Tag tag = new Tag();
			tag.setCrateTime(new Date());
			tag.setTagName("测试标签" + i);
			tagDao.save(tag);
		}
	}

	@Test
	public void testFindTagByTagName() {
		Tag tag = tagDao.findTagByTagName("标签3");
		tag.setTagName("标签-3");
		System.out.println(tag);
	}

}
