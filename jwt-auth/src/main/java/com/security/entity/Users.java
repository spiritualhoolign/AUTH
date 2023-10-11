package com.security.entity;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class Users implements UserDetails{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "active_flag")
	private boolean activeFlag;
	

    @ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
        name="user_role_junction",
        joinColumns = {@JoinColumn(name="email")},
        inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private Set<Roles> authorities;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return this.authorities;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.fullName;
	}


	@Override
	public boolean isAccountNonExpired() {
		return this.activeFlag;
	}


	@Override
	public boolean isAccountNonLocked() {
		return this.activeFlag;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return this.activeFlag;
	}


	@Override
	public boolean isEnabled() {
		return this.activeFlag;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public boolean isActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setAuthorities(Set<Roles> authorities) {
		this.authorities = authorities;
	}


	public Users(long l, String email, String fullName, boolean activeFlag, Set<Roles> authorities) {
		super();
		this.id = l;
		this.email = email;
		this.fullName = fullName;
		this.activeFlag = activeFlag;
		this.authorities = authorities;
	}


	public Users() {
		super();
		
	}


	public Users(String email, String fullName, boolean activeFlag, Set<Roles> authorities) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.activeFlag = activeFlag;
		this.authorities = authorities;
	}


	
}
