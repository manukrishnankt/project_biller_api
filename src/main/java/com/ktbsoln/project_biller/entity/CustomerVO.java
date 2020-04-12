package com.ktbsoln.project_biller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_phone")
	private String customerPhone;

	@Column(name = "customer_address_id")
	private Long customerAddressId;

	@Column(name = "customer_gender")
	private String customerGender;

	@Column(name = "customer_email")
	private String customerEmail;

	@Column(name = "customer_record_status")
	private String customerRecordStatus;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Long getCustomerAddressId() {
		return customerAddressId;
	}

	public void setCustomerAddressId(Long customerAddressId) {
		this.customerAddressId = customerAddressId;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerRecordStatus() {
		return customerRecordStatus;
	}

	public void setCustomerRecordStatus(String customerRecordStatus) {
		this.customerRecordStatus = customerRecordStatus;
	}
}
