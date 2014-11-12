package com.channelsoft.assistant.controller.to;

import java.util.List;

/**
 * 结果信息返回
 * @author tenanty
 *
 * @param <T>
 */
public class DatatablesResponse<T> {
	
	public static final String STATUS_SUCCESS = "0";
	public static final String STATUS_FAILURE = "1";

	public DatatablesResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	// 0：成功 1：失败
	private String status;
	// 消息信息
	private String message;
	// 操作数据编号
	private Long id;
	
	// 数据信息
	private List<T> data;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
