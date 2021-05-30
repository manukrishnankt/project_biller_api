package com.ktbsoln.project_biller.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "company_id")
	private Long companyId;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_currency")
	private String companyCurrency;

	@Column(name = "company_address_id")
	private Long companyAddressId;

	@Column(name = "company_created_date")
	private Timestamp companyCreatedDate;

	@Column(name = "company_record_status")
	private String companyRecordStatus;
	
	@Column(name = "company_login_credential_id")
	private Long companyLoginCredentialId;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCurrency() {
		return companyCurrency;
	}

	public void setCompanyCurrency(String companyCurrency) {
		this.companyCurrency = companyCurrency;
	}

	public Long getCompanyAddressId() {
		return companyAddressId;
	}

	public void setCompanyAddressId(Long companyAddressId) {
		this.companyAddressId = companyAddressId;
	}

	public Timestamp getCompanyCreatedDate() {
		return companyCreatedDate;
	}

	public void setCompanyCreatedDate(Timestamp companyCreatedDate) {
		this.companyCreatedDate = companyCreatedDate;
	}

	public String getCompanyRecordStatus() {
		return companyRecordStatus;
	}

	public void setCompanyRecordStatus(String companyRecordStatus) {
		this.companyRecordStatus = companyRecordStatus;
	}

	public Long getCompanyLoginCredentialId() {
		return companyLoginCredentialId;
	}

	public void setCompanyLoginCredentialId(Long companyLoginCredentialId) {
		this.companyLoginCredentialId = companyLoginCredentialId;
	}
	
}
