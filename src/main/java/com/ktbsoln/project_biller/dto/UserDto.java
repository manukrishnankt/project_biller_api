package com.ktbsoln.project_biller.dto;

public class UserDto {
	
	private String loginCredentialUserName;
	private String loginCredentialPassword;
	private String loginCredentialPasswordHint;
	private Long loginCredentialCompanyId;
	private Long authorityId;
//	private Timestamp loginCredentialCreatedDate;
//	private String loginCredentialRecordStatus;
//	private String loginCredentialComapnyName;
//	private boolean enabledYN;
//	private List<GrantedAuthority> grantedAuthorities;
	
	public UserDto() {}

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

	public Long getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}
	
}
