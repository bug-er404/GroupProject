package com.group.groupoproject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_name")
	private String userName;
	
	private String password;
	
	private String title;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
	
	@Column(name="created_time")
	private Date createdTime;
	
	@Column(name="update_time")
	private Date updateTime;
	
	@OneToMany(fetch=FetchType.LAZY,
			   mappedBy="owner",
			   cascade= {CascadeType.ALL})
	private List<Project> projects;

	public User() {
		this.createdTime = new Date();
	}

	public User(String name, String password, String title, Role role) {
		this.userName = name;
		this.password = password;
		this.title = title;
		this.role = role;
		this.createdTime = new Date();
	}
	
	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
		this.updateTime = new Date();
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
		this.updateTime = new Date();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		this.updateTime = new Date();
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
		this.updateTime = new Date();
	}
	public Date getCreatedTime() {
		return createdTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
