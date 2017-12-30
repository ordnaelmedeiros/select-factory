package com.medeiros.ordnael.selectfactory.entitys.build;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.medeiros.ordnael.selectfactory.entitys.component.Version;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(name="unique_Build_on_Version", columnNames = {"versionId", "build"}))
public class Build {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="versionId", nullable=false, foreignKey=@ForeignKey(name="fk_Build_Version"))
	private Version version;

	@Column(nullable=false)
	private LocalDateTime creation;
	
	@Column(insertable=false)
	private LocalDateTime complete;
	
	@Column(insertable=false)
	private LocalDateTime death;

	@Column
	private Integer size;
	
	@Column(nullable=false)
	private Integer build;
	
	@Column(columnDefinition="text")
	private String notes;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private BuildStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public LocalDateTime getComplete() {
		return complete;
	}

	public void setComplete(LocalDateTime complete) {
		this.complete = complete;
	}

	public LocalDateTime getDeath() {
		return death;
	}

	public void setDeath(LocalDateTime death) {
		this.death = death;
	}

	public Integer getBuild() {
		return build;
	}

	public void setBuild(Integer build) {
		this.build = build;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public BuildStatus getStatus() {
		return status;
	}

	public void setStatus(BuildStatus status) {
		this.status = status;
	}
	
}
