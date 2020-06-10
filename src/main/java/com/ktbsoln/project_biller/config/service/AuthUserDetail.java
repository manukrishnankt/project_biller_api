package com.ktbsoln.project_biller.config.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ktbsoln.project_biller.dto.LoginCredentialDto;

public class AuthUserDetail implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> grantedAuthorities;
	
	public AuthUserDetail(LoginCredentialDto userDto) {
		this.userName = userDto.getLoginCredentialUserName();
		this.password = userDto.getLoginCredentialPassword();
		this.enabled = userDto.isEnabledYN();
		this.grantedAuthorities = userDto.getGrantedAuthorities();
	}
	
	public AuthUserDetail() { }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

}
