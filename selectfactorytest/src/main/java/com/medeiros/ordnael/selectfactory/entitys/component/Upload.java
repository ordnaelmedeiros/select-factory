package com.medeiros.ordnael.selectfactory.entitys.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.medeiros.ordnael.selectfactory.entitys.User;
import com.medeiros.ordnael.selectfactory.entitys.build.Build;

@Entity
@Table
public class Upload {

	@Id
	private Long uploadId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="buildId", foreignKey=@ForeignKey(name="fk_Upload_Build"), insertable=false, updatable=false)
	private Build build;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId", foreignKey=@ForeignKey(name="fk_Upload_User"), insertable=false, updatable=false)
	private User user;
	
	@Column(nullable=false, updatable=false)
	private byte[] bytes;

	public Long getUploadId() {
		return uploadId;
	}

	public void setUploadId(Long id) {
		this.uploadId = id;
	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
