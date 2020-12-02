package com.group.groupoproject.models;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "owner")
	private User owner;

	@Column(name = "created_time")
	private Date createdTime;
	
	@OneToMany(mappedBy = "project")
	private List<Property> properties;

	@ManyToMany()
	@JoinTable(name = "Project_Resource", joinColumns = { @JoinColumn(name = "project_id") }, inverseJoinColumns = {
			@JoinColumn(name = "resource_id") })
	Set<Resource> resources = new HashSet<>();

	public Project() {
		this.createdTime = new Date();
	}

	public Project(User owner) {
		this.owner = owner;
		this.createdTime = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
}
