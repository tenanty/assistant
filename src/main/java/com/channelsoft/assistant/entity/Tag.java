package com.channelsoft.assistant.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 标记实体对象
 * 
 * @author tenanty
 * 
 */
@Entity
@Table(name = "tag")
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8208934043099090309L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tagId;
	private String tagName;
	private Date crateTime;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "tags", fetch = FetchType.LAZY)
	private Set<Customer> custs;

	@JsonIgnore
	public Set<Customer> getCusts() {
		return custs;
	}

	public void setCusts(Set<Customer> custs) {
		this.custs = custs;
	}

	@Column(name = "tag_id")
	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	@Column(name = "tag_name", unique = true, nullable = true, columnDefinition = "标记名")
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Column(name = "create_time", columnDefinition = "创建时间")
	public Date getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
	}

	public Tag() {
		super();
	}

	public Tag(String tagName, Date crateTime) {
		super();
		this.tagName = tagName;
		this.crateTime = crateTime;
	}

	@Override
	public String toString() {
		return "TagInfo [tagId=" + tagId + ", tagName=" + tagName
				+ ", crateTime=" + crateTime + "]";
	}

}
