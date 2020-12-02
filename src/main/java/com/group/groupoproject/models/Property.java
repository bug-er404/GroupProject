package com.group.groupoproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "formula_text")
	private String formulaText;

	private String type;
	@Column(name = "created_time")
	private Date createdTime;

	@OneToMany(mappedBy = "property")
	private List<ResourceDetail> resourceDetails;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "project")
	private Project project;

	public Property() {
		this.createdTime = new Date();
	}

	public Property(String name, String type, String formulaText) {
		this.name = name;
		this.type = type;
		this.formulaText = formulaText;
		this.createdTime = new Date();
	}

}
