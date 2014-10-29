package com.channelsoft.assistant.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.channelsoft.assistant.entity.Account;
import com.channelsoft.assistant.service.AccountService;

/**
 * �û�ע���Controller.
 * 
 * @author tenanty
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AccountService accountInfoService;

	@RequestMapping(method = RequestMethod.GET)
	public String registerForm() {
		logger.debug("���� RegisterController.RegisterController");
		return "account/register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(@Valid Account user, RedirectAttributes redirectAttributes) {
		logger.debug("���� RegisterController.register");
		accountInfoService.registerUser(user);
		logger.debug("{}ע��ɹ�.",user);
		redirectAttributes.addFlashAttribute("username", user.getAccount());
		redirectAttributes.addFlashAttribute("message", "ע��ɹ�.");
		return "redirect:/login";
	}

	/**
	 * Ajax����У��loginName�Ƿ�Ψһ��
	 */
	@RequestMapping(value = "checkLoginName")
	@ResponseBody
	public String checkLoginName(@RequestParam("loginName") String loginName) {
		logger.debug("���� RegisterController.checkLoginName");
		if (accountInfoService.findUserByLoginName(loginName) == null) {
			return "true";
		} else {
			return "false";
		}
	}
}

