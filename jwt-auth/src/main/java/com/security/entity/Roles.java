package com.security.entity;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class Roles implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "role_id")
	private Long id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "assigned_app")
	private String appAssigned;
	
	@Column(name = "user_role")
	private String role;

	@Column(name = "active_flag")
	private boolean activeFlag;
	
	@Override
	public String getAuthority() {
		return this.role;
	}

	public Roles(Long userId, String appAssigned, String role, boolean activeFlag) {
		super();
		this.userId = userId;
		this.appAssigned = appAssigned;
		this.role = role;
		this.activeFlag = activeFlag;
	}

	public Roles() {
		super();
		
	}

	
	
}
