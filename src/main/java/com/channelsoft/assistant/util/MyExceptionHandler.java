package com.channelsoft.assistant.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常处理类
 * 
 * @author tenanty
 *
 */
public class MyExceptionHandler implements HandlerExceptionResolver {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		logger.debug("进入 MyExceptionHandler.resolveException()");
		 Map<String, Object> model = new HashMap<String, Object>();  
	        model.put("ex", ex);  
	            return new ModelAndView("error", model);  
	}

}
