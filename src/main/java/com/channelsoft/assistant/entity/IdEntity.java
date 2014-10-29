package com.channelsoft.assistant.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * ͳһ����id��entity����.
 * 
 * ����ͳһ����id���������ơ��������͡�����ӳ�估���ɲ���.
 * Oracle��Ҫÿ��Entity��������id��SEQUCENCEʱ�����̳��ڱ������Ϊʵ��һ��Idable�Ľӿڡ�
 * 
 * @author calvin
 */
// JPA ����ı�ʶ
@MappedSuperclass
public abstract class IdEntity {

	protected Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
