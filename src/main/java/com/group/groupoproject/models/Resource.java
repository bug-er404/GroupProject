package com.group.groupoproject.models;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "created_time")
	private Date createdTime;

	@Column(name = "update_time")
	private Date updateTime;

	@ManyToMany(mappedBy = "resources")
	private Set<Project> projects = new HashSet<>();

	@OneToMany(mappedBy = "resource")
	private List<ResourceDetail> resourceDetails;

	public Resource() {

	}

	public Resource(String name) {
		this.name = name;
		this.createdTime = new Date();
	}
}
