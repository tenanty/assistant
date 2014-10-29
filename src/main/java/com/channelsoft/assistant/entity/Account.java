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
 * 账号信息
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
	private Long accountId;//编号
	private String account;//账号
	private String name;//姓名
	@Transient
	private String plainPassword;//密码--页面传入
	private String password;//密码-持久化使用
	private String salt;//密码盐
	private Date registerTime;//注册时间
	private Date activeTime;//激活时间
	private Date lastLoginTime;//最后一次登录时间
	private String phone;//手机
	private String roles;//角色
	private String email;//电子邮箱
	
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
		// 角色列表在数据库中实际以逗号分隔字符串存储，因此返回不能修改的List.
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

//	// 标签
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
