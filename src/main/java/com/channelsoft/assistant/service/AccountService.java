package com.channelsoft.assistant.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.assistant.entity.Account;
import com.channelsoft.assistant.repository.AccountDao;
import com.channelsoft.assistant.util.Digests;
import com.channelsoft.assistant.util.Encodes;

/**
 * �˻���Ϣҵ���߼�
 * @author tenanty
 *
 */
@Service
public class AccountService {
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	
	
	@Autowired
	private AccountDao accountInfoDao;

	/**
	 * �û�ע��
	 * @param user
	 */
	public void registerUser(Account user) {
		entryptPassword(user);
		user.setRoles("user");
		user.setRegisterTime(new Date());
		accountInfoDao.save(user);
	}
	
	/**
	 * ͨ���˺Ż�ȡ�˻���Ϣ
	 * @param username
	 * @return
	 */
	public Account findAccountInfoByAccount(String username) {
		return accountInfoDao.findAccountByAccount(username);
	}
	
	/**
	 * �趨��ȫ�����룬���������salt������1024�� sha-1 hash
	 */
	private void entryptPassword(Account user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	/**
	 * ͨ���˺Ż�ȡ�û���Ϣ
	 * @param loginName
	 * @return
	 */
	public Object findUserByLoginName(String loginName) {
		
		return null;
	}
	

}
