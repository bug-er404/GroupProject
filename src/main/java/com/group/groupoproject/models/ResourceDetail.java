package com.group.groupoproject.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ResourceDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "created_time")
	private Date createdTime;

	@Column(name = "update_time")
	private Date updateTime;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "resource")
	private Resource resource;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "property")
	private Property property;

	private String value;

	public ResourceDetail() {

	}

	public ResourceDetail(Resource resource, Property property, String value) {
		this.resource = resource;
		this.property = property;
		this.value = value;
		this.createdTime = new Date();
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = new Date();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		this.updateTime = new Date();
	}

	public int getId() {
		return id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public Resource getResource() {
		return resource;
	}

	public Property getProperty() {
		return property;
	}
}
