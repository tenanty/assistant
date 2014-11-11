package com.channelsoft.assistant.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * 邮件发送业务对象
 * 
 * @author tenanty
 * 
 */
@Service
public class MailSendService {
	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;

	public String sendSimpleMail(String username, String password) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("qnsoft010@126.com");
		mail.setTo("yuanshun@channelsoft.com");
		mail.setSubject(" 测试spring Mail");
		mail.setText("hello,java <a href='http://www.baidu.com'>百度</a>");
		javaMailSenderImpl.send(mail);
		return "0";
	}

	public String sendMimeMail() {
		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "gbk");
		// 设置收件人，寄件人
		try {
			messageHelper.setTo("yuanshun@channelsoft.com");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			messageHelper.setFrom("qnsoft010@126.com");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			messageHelper.setSubject("测试HTML邮件!");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// true 表示启动HTML格式的邮件
		try {
			messageHelper
					.setText(
							"<html><head></head><body><h1>hello!!spring html Mail</h1><a href='http://www.baidu.com'>百度</a></body></html>",
							true);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.timeout", "25000");

		javaMailSenderImpl.setJavaMailProperties(prop);
		javaMailSenderImpl.send(mimeMessage);

		return "0";
	}

}
