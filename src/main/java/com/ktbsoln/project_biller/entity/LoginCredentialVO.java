package com.ktbsoln.project_biller.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login_credential")
public class LoginCredentialVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "lc_id")
	private Long loginCredentialId;

	@Column(name = "lc_username")
	private String loginCredentialUserName;
	
	@Column(name = "lc_password")
	private String loginCredentialPassword;

	@Column(name = "lc_password_hint")
	private String loginCredentialPasswordHint;
	
	@Column(name = "lc_company_id")
	private Long loginCredentialCompanyId;

	@Column(name = "lc_created_date")
	private Timestamp loginCredentialCreatedDate;

	@Column(name = "lc_record_status")
	private String loginCredentialRecordStatus;

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
}
