package com.channelsoft.assistant.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * �绰��Ϣ
 * 
 * @author tenanty
 * 
 */
@Entity
@Table(name = "phone")
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long phoneId;
	private String phoneDesc;
	private String phoneNo;
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "custId", insertable = true, updatable = true)
	private Customer custInfo;

	@Column(name = "phone_id")
	public Long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(Long phoneId) {
		this.phoneId = phoneId;
	}

	@Column(name = "phone_desc")
	public String getPhoneDesc() {
		return phoneDesc;
	}

	public void setPhoneDesc(String phoneDesc) {
		this.phoneDesc = phoneDesc;
	}

	@Column(name = "phone_no")
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "PhoneInfo [phoneId=" + phoneId + ", phoneDesc=" + phoneDesc + ", phoneNo=" + phoneNo + "]";
	}
}