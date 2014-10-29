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
 * �ʼ�����ҵ�����
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
		mail.setSubject(" ����spring Mail");
		mail.setText("hello,java <a href='http://www.baidu.com'>�ٶ�</a>");
		javaMailSenderImpl.send(mail);
		return "0";
	}

	public String sendMimeMail() {
		MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "gbk");
		// �����ռ��ˣ��ļ���
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
			messageHelper.setSubject("����HTML�ʼ���");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// true ��ʾ����HTML��ʽ���ʼ�
		try {
			messageHelper
					.setText(
							"<html><head></head><body><h1>hello!!spring html Mail</h1><a href='http://www.baidu.com'>�ٶ�</a></body></html>",
							true);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true"); // �����������Ϊtrue���÷�����������֤,��֤�û����������Ƿ���ȷ
		prop.put("mail.smtp.timeout", "25000");

		javaMailSenderImpl.setJavaMailProperties(prop);
		javaMailSenderImpl.send(mimeMessage);

		return "0";
	}

}
