package com.channelsoft.assistant.util;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class CacheUtil {

	LoadingCache<String, Serializable> studentCache = CacheBuilder.newBuilder().concurrencyLevel(8)
			.expireAfterWrite(8, TimeUnit.SECONDS).initialCapacity(10).maximumSize(100).recordStats()
			.removalListener(new RemovalListener<Object, Object>() {
				public void onRemoval(RemovalNotification<Object, Object> notification) {
					System.out.println(notification.getKey() + " was removed, cause is " + notification.getCause());
				}
			}).build(new CacheLoader<String, Serializable>() {
				@Override
				public Serializable load(String key) throws Exception {
					RandomStringUtils ran = new RandomStringUtils();
					System.out.println("load student " + key);
					return RandomStringUtils.random(10);
				}
			});

	private CacheUtil() {
	}

	private static CacheUtil cacheUtil;

	public synchronized static CacheUtil getInstance() {
		if (cacheUtil == null) {
			cacheUtil = new CacheUtil();
		}
		return cacheUtil;
	}

	public String getToken(String key) {
		try {
			String str = (String) studentCache.get(key);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RandomStringUtils.random(10);
		return null;
	}

}
