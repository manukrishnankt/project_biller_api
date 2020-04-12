package com.ktbsoln.project_biller.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "emp_id")
	private Long employeeId;

	@Column(name = "emp_name")
	private String employeeName;
	
	@Column(name = "emp_dob")
	private Date employeeDOB;

	@Column(name = "emp_company_id")
	private Long employeeCompanyId;
	
	@Column(name = "emp_lc_id")
	private Long employeeLoginCredentialId;

	@Column(name = "emp_bloodgroup")
	private String employeeBloodGroup;
	
	@Column(name = "emp_parentname")
	private String employeeParentName;

	@Column(name = "emp_identity_id")
	private Long employeeIdentityId;
	
	@Column(name = "emp_gender")
	private String employeeGender;
	
	@Column(name = "emp_phone")
	private String employeePhone;
	
	@Column(name = "emp_email")
	private String employeeEmail;

	@Column(name = "emp_nationality")
	private String employeeNationality;
	
	@Column(name = "emp_address_id")
	private Long employeeAddressId;

	@Column(name = "emp_created")
	private Timestamp employeeCreatedDate;
	
	@Column(name = "emp_record_status")
	private String employeeRecordStatus;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Date getEmployeeDOB() {
		return employeeDOB;
	}

	public void setEmployeeDOB(Date employeeDOB) {
		this.employeeDOB = employeeDOB;
	}

	public Long getEmployeeCompanyId() {
		return employeeCompanyId;
	}

	public void setEmployeeCompanyId(Long employeeCompanyId) {
		this.employeeCompanyId = employeeCompanyId;
	}

	public Long getEmployeeLoginCredentialId() {
		return employeeLoginCredentialId;
	}

	public void setEmployeeLoginCredentialId(Long employeeLoginCredentialId) {
		this.employeeLoginCredentialId = employeeLoginCredentialId;
	}

	public String getEmployeeBloodGroup() {
		return employeeBloodGroup;
	}

	public void setEmployeeBloodGroup(String employeeBloodGroup) {
		this.employeeBloodGroup = employeeBloodGroup;
	}

	public String getEmployeeParentName() {
		return employeeParentName;
	}

	public void setEmployeeParentName(String employeeParentName) {
		this.employeeParentName = employeeParentName;
	}

	public Long getEmployeeIdentityId() {
		return employeeIdentityId;
	}

	public void setEmployeeIdentityId(Long employeeIdentityId) {
		this.employeeIdentityId = employeeIdentityId;
	}

	public String getEmployeeGender() {
		return employeeGender;
	}

	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeNationality() {
		return employeeNationality;
	}

	public void setEmployeeNationality(String employeeNationality) {
		this.employeeNationality = employeeNationality;
	}

	public Long getEmployeeAddressId() {
		return employeeAddressId;
	}

	public void setEmployeeAddressId(Long employeeAddressId) {
		this.employeeAddressId = employeeAddressId;
	}

	public Timestamp getEmployeeCreatedDate() {
		return employeeCreatedDate;
	}

	public void setEmployeeCreatedDate(Timestamp employeeCreatedDate) {
		this.employeeCreatedDate = employeeCreatedDate;
	}

	public String getEmployeeRecordStatus() {
		return employeeRecordStatus;
	}

	public void setEmployeeRecordStatus(String employeeRecordStatus) {
		this.employeeRecordStatus = employeeRecordStatus;
	}

}
