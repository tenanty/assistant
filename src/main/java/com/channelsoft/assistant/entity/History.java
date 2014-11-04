package com.channelsoft.assistant.entity;

import java.io.Serializable;
import java.util.Date;

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
 * 历史记录管理
 * 
 * @author tenanty
 * 
 */
@Entity
@Table(name = "history")
public class History implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long historyId;
	private String remark;
	private Date createTime;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "custId", insertable = true, updatable = true)
	private Customer custInfo;

	public Customer getCustInfo() {
		return custInfo;
	}

	public void setCustInfo(Customer custInfo) {
		this.custInfo = custInfo;
	}

	@Column(name = "history_id")
	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "HistoryInfo [historyId=" + historyId + ", remark=" + remark + ", createTime=" + createTime + "]";
	}

}
