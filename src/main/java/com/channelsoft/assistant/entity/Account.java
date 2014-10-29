package com.channelsoft.assistant.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.ImmutableList;

/**
 * �˺���Ϣ
 * 
 * @author tenanty
 * 
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -707817043323114249L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;//���
	private String account;//�˺�
	private String name;//����
	@Transient
	private String plainPassword;//����--ҳ�洫��
	private String password;//����-�־û�ʹ��
	private String salt;//������
	private Date registerTime;//ע��ʱ��
	private Date activeTime;//����ʱ��
	private Date lastLoginTime;//���һ�ε�¼ʱ��
	private String phone;//�ֻ�
	private String roles;//��ɫ
	private String email;//��������
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	@Transient
	public List<String> getRoleList() {
		// ��ɫ�б������ݿ���ʵ���Զ��ŷָ��ַ����洢����˷��ز����޸ĵ�List.
		return ImmutableList.copyOf(StringUtils.split(roles, ","));
	}
	
	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@JsonIgnore
	public String getPlainPassword() {
		return plainPassword;
	}

	public void setPlainPassword(String plainPassword) {
		this.plainPassword = plainPassword;
	}

//	// ��ǩ
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "accountInfo", fetch = FetchType.EAGER)
//	private Set<Tag> tags;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registTime) {
		this.registerTime = registTime;
	}

	public Date getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

//	public Set<Tag> getTags() {
//		return tags;
//	}
//
//	public void setTags(Set<Tag> tags) {
//		this.tags = tags;
//	}
	
	public Account(Long accountId) {
		super();
		this.accountId = accountId;
	}

	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "AccountInfo [accountId=" + accountId + ", account=" + account + ", name=" + name + ", password="
				+ password + ", salt=" + salt + ", registTime=" + registerTime + ", activeTime=" + activeTime
				+ ", lastLoginTime=" + lastLoginTime + "]";
	}

}
