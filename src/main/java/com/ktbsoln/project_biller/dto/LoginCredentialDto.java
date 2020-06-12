package com.ktbsoln.project_biller.dto;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.ktbsoln.project_biller.utils.PBillerConstants;

public class LoginCredentialDto {
	
	private Long loginCredentialId;
	private String loginCredentialUserName;
	private String loginCredentialPassword;
	private String loginCredentialPasswordHint;
	private Long loginCredentialCompanyId;
	private Timestamp loginCredentialCreatedDate;
	private String loginCredentialRecordStatus;
	private String loginCredentialComapnyName;
	private boolean enabledYN;
	private List<GrantedAuthority> grantedAuthorities;
	
	public LoginCredentialDto() {}
	
	public LoginCredentialDto(Long loginCredentialId, String loginCredentialUserName, 
			String loginCredentialPassword, String loginCredentialRecordStatus, List<GrantedAuthority> grantedAuthorities) {
		this.enabledYN =  PBillerConstants.RECORD_STATUS_ACTIVE.equals(loginCredentialRecordStatus);
		this.loginCredentialId = loginCredentialId;
		this.loginCredentialUserName = loginCredentialUserName;
		this.loginCredentialPassword = loginCredentialPassword;
		this.grantedAuthorities = grantedAuthorities;
		
	}
	
	public Long getLoginCredentialId() {
		return loginCredentialId;
	}
	public void setLoginCredentialId(Long loginCredentialId) {
		this.loginCredentialId = loginCredentialId;
	}
	public String getLoginCredentialUserName() {
		return loginCredentialUserName;
	}
	public void setLoginCredentialUserName(String loginCredentialUserName) {
		this.loginCredentialUserName = loginCredentialUserName;
	}
	public String getLoginCredentialPassword() {
		return loginCredentialPassword;
	}
	public void setLoginCredentialPassword(String loginCredentialPassword) {
		this.loginCredentialPassword = loginCredentialPassword;
	}
	public String getLoginCredentialPasswordHint() {
		return loginCredentialPasswordHint;
	}
	public void setLoginCredentialPasswordHint(String loginCredentialPasswordHint) {
		this.loginCredentialPasswordHint = loginCredentialPasswordHint;
	}
	public Long getLoginCredentialCompanyId() {
		return loginCredentialCompanyId;
	}
	public void setLoginCredentialCompanyId(Long loginCredentialCompanyId) {
		this.loginCredentialCompanyId = loginCredentialCompanyId;
	}
	public Timestamp getLoginCredentialCreatedDate() {
		return loginCredentialCreatedDate;
	}
	public void setLoginCredentialCreatedDate(Timestamp loginCredentialCreatedDate) {
		this.loginCredentialCreatedDate = loginCredentialCreatedDate;
	}
	public String getLoginCredentialRecordStatus() {
		return loginCredentialRecordStatus;
	}
	public void setLoginCredentialRecordStatus(String loginCredentialRecordStatus) {
		this.loginCredentialRecordStatus = loginCredentialRecordStatus;
	}
	public String getLoginCredentialComapnyName() {
		return loginCredentialComapnyName;
	}
	public void setLoginCredentialComapnyName(String loginCredentialComapnyName) {
		this.loginCredentialComapnyName = loginCredentialComapnyName;
	}
	public boolean isEnabledYN() {
		return enabledYN;
	}
	public void setEnabledYN(boolean enabledYN) {
		this.enabledYN = enabledYN;
	}
	public List<GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}
	public void setGrantedAuthorities(List<GrantedAuthority> grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}
}
