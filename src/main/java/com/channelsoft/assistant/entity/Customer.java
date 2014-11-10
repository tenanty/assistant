package com.channelsoft.assistant.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 客户信息
 * 
 * @author tenanty
 * 
 */
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long custId;// 编号
	private String custName;// 姓名
	private String custCompany;// 公司
	private String custJob;// 职务
	private String custAddress;// 地址
	private String custPortrait;// 头像
	private String remark;// 备注

	// 传输对象
	@Transient
	private String inputPhone;// 输入电话
	@Transient
	private String inputEmail;// 输入邮箱
	@Transient
	private String tag;// 标签

	// 邮箱
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "customer", fetch = FetchType.EAGER)
	private Set<Email> emails;
	// 电话
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "custInfo", fetch = FetchType.EAGER)
	private Set<Phone> phones;
	// 联络历史
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "custInfo", fetch = FetchType.EAGER)
	private Set<History> histories;
	// 标记
	@ManyToMany(targetEntity = Tag.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "cust_tag", joinColumns = { @JoinColumn(name = "cust_id", referencedColumnName = "custId") }, inverseJoinColumns = { @JoinColumn(name = "tag_id", referencedColumnName = "tagId") })
	private Set<Tag> tags;

	public Customer(Long custId) {
		super();
		this.custId = custId;
	}

	public String getInputPhone() {
		if (StringUtils.isNotBlank(inputPhone)) {
			return inputPhone;
		}
		if (phones == null || phones.size() == 0) {
			return StringUtils.EMPTY;
		}
		StringBuilder sb = new StringBuilder();
		for (Phone phone : phones) {
			sb.append(phone.getPhoneNo()).append(",");
		}
		return sb.toString();
	}

	public void setInputPhone(String inputPhone) {
		this.inputPhone = inputPhone;
	}

	public String getInputEmail() {
		if (StringUtils.isNotBlank(inputEmail)) {
			return inputEmail;
		}
		if (emails == null || emails.size() == 0) {
			return StringUtils.EMPTY;
		}
		StringBuilder sb = new StringBuilder();
		for (Email email : emails) {
			sb.append(email.getEmailAddress()).append(",");
		}
		return sb.toString();
	}

	public void setInputEmail(String inputEmail) {
		this.inputEmail = inputEmail;
	}

	public String getTag() {
		if (StringUtils.isNotBlank(tag)) {
			return tag;
		}
		if (tags == null || tags.size() == 0) {
			return StringUtils.EMPTY;
		}
		StringBuilder sb = new StringBuilder();
		for (Tag tag : tags) {
			sb.append(tag.getTagName()).append(",");
		}
		return sb.toString();
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@JsonIgnore
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Column(name = "cust_id")
	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	@Column(name = "cust_name")
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "cust_company")
	public String getCustCompany() {
		return custCompany;
	}

	public void setCustCompany(String custCompany) {
		this.custCompany = custCompany;
	}

	@Column(name = "cust_job")
	public String getCustJob() {
		return custJob;
	}

	public void setCustJob(String custJob) {
		this.custJob = custJob;
	}

	@Column(name = "cust_address")
	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	@Column(name = "cust_portrait")
	public String getCustPortrait() {
		return custPortrait;
	}

	public void setCustPortrait(String custPortrait) {
		this.custPortrait = custPortrait;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@JsonIgnore
	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	@JsonIgnore
	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Customer(Long custId, String custName, String custCompany,
			String custJob, String custAddress, String custPortrait,
			String remark) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custCompany = custCompany;
		this.custJob = custJob;
		this.custAddress = custAddress;
		this.custPortrait = custPortrait;
		this.remark = remark;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "CustInfo [custId=" + custId + ", custName=" + custName
				+ ", custCompany=" + custCompany + ", custJob=" + custJob
				+ ", custAddress=" + custAddress + ", custPortrait="
				+ custPortrait + ", remark=" + remark + ", emails=" + emails
				+ ", phones=" + phones + "]";
	}

}
