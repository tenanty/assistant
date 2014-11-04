package com.channelsoft.assistant.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.assistant.entity.Account;
import com.channelsoft.assistant.repository.AccountDao;
import com.channelsoft.assistant.util.Digests;
import com.channelsoft.assistant.util.Encodes;

/**
 * 账户信息业务逻辑
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
	 * 用户注册
	 * @param user
	 */
	public void registerUser(Account user) {
		entryptPassword(user);
		user.setRoles("user");
		user.setRegisterTime(new Date());
		accountInfoDao.save(user);
	}
	
	/**
	 * 通过账号获取账户信息
	 * @param username
	 * @return
	 */
	public Account findAccountInfoByAccount(String username) {
		return accountInfoDao.findAccountByAccount(username);
	}
	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(Account user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPassword().getBytes(), salt, HASH_INTERATIONS);
		user.setPassword(Encodes.encodeHex(hashPassword));
	}

	/**
	 * 通过账号获取用户信息
	 * @param loginName
	 * @return
	 */
	public Object findUserByLoginName(String loginName) {
		
		return null;
	}
	

}
