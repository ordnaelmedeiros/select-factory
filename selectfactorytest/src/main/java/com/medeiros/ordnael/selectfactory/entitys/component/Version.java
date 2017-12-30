package com.medeiros.ordnael.selectfactory.entitys.component;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(name="unique_Version_on_Component", columnNames = {"componentId", "major", "minor", "release"}))
public class Version {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="componentId", nullable=false, foreignKey=@ForeignKey(name="fk_version_component"))
	private Component component;
	
	@Column(nullable=false)
	private LocalDateTime creation;
	
	@Column(insertable=false)
	private LocalDateTime death;
	
	@Column(nullable=false)
	private Integer major;
	
	@Column(nullable=false)
	private Integer minor;
	
	@Column(nullable=false)
	private Integer release;

	@Column(columnDefinition="text")
	private String description;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public LocalDateTime getCreation() {
		return creation;
	}

	public void setCreation(LocalDateTime creation) {
		this.creation = creation;
	}

	public LocalDateTime getDeath() {
		return death;
	}

	public void setDeath(LocalDateTime death) {
		this.death = death;
	}

	public Integer getMajor() {
		return major;
	}

	public void setMajor(Integer major) {
		this.major = major;
	}

	public Integer getMinor() {
		return minor;
	}

	public void setMinor(Integer minor) {
		this.minor = minor;
	}

	public Integer getRelease() {
		return release;
	}

	public void setRelease(Integer release) {
		this.release = release;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}