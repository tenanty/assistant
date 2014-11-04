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
 * 邮件信息
 * 
 * @author tenanty
 * 
 */
@Entity
@Table(name = "email")
public class Email implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7577186437608716200L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emailId;
	private String emailDesc;
	private String emailAddress;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "custId", insertable = true, updatable = true)
	private Customer custInfo;

	public Customer getCustInfo() {
		return custInfo;
	}

	public void setCustInfo(Customer custInfo) {
		this.custInfo = custInfo;
	}

	@Column(name = "email_id")
	public Long getEmailId() {
		return emailId;
	}

	public void setEmailId(Long emailId) {
		this.emailId = emailId;
	}

	@Column(name = "email_desc")
	public String getEmailDesc() {
		return emailDesc;
	}

	public void setEmailDesc(String emailDesc) {
		this.emailDesc = emailDesc;
	}

	@Column(name = "email_address")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public Email() {
		super();
	}

	public Email(Long emailId, String emailDesc, String emailAddress,
			Customer custInfo) {
		super();
		this.emailId = emailId;
		this.emailDesc = emailDesc;
		this.emailAddress = emailAddress;
		this.custInfo = custInfo;
	}

	@Override
	public String toString() {
		return "EmailInfo [emailId=" + emailId + ", emailDesc=" + emailDesc + ", emailAddress=" + emailAddress + "]";
	}
}
