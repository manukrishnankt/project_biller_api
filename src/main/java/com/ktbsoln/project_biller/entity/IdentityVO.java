package com.ktbsoln.project_biller.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "identity")
public class IdentityVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "identity_id")
	private Long identityId;

	@Column(name = "identity_name")
	private String identityName;
	
	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "identity_type")
	private String identityType;
	
	@Column(name = "identity_created_date")
	private Timestamp identityCreatedDate;

	@Column(name = "identity_record_status")
	private String identityRecordStatus;

	public Long getIdentityId() {
		return identityId;
	}

	public void setIdentityId(Long identityId) {
		this.identityId = identityId;
	}

	public String getIdentityName() {
		return identityName;
	}

	public void setIdentityName(String identityName) {
		this.identityName = identityName;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public Timestamp getIdentityCreatedDate() {
		return identityCreatedDate;
	}

	public void setIdentityCreatedDate(Timestamp identityCreatedDate) {
		this.identityCreatedDate = identityCreatedDate;
	}

	public String getIdentityRecordStatus() {
		return identityRecordStatus;
	}

	public void setIdentityRecordStatus(String identityRecordStatus) {
		this.identityRecordStatus = identityRecordStatus;
	}
}
