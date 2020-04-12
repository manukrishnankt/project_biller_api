package com.ktbsoln.project_biller.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class AddressVO {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="address_id")
    private Long addressId;
     
    @Column(name="address_building_name")
    private String addressBuildingName;

    @Column(name="address_pin")
    private String addressPin;
    
    @Column(name="address_country_id")
    private Long addressCountryId;
    
    @Column(name="address_state_id")
    private Long addressStateId;
    
    @Column(name="address_created_date")
    private Timestamp addressCreatedDate;
    
    @Column(name="address_record_status")
    private String addressRecordStatus ;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddressBuildingName() {
		return addressBuildingName;
	}

	public void setAddressBuildingName(String addressBuildingName) {
		this.addressBuildingName = addressBuildingName;
	}

	public String getAddressPin() {
		return addressPin;
	}

	public void setAddressPin(String addressPin) {
		this.addressPin = addressPin;
	}

	public Long getAddressCountryId() {
		return addressCountryId;
	}

	public void setAddressCountryId(Long addressCountryId) {
		this.addressCountryId = addressCountryId;
	}

	public Long getAddressStateId() {
		return addressStateId;
	}

	public void setAddressStateId(Long addressStateId) {
		this.addressStateId = addressStateId;
	}

	public Timestamp getAddressCreatedDate() {
		return addressCreatedDate;
	}

	public void setAddressCreatedDate(Timestamp addressCreatedDate) {
		this.addressCreatedDate = addressCreatedDate;
	}

	public String getAddressRecordStatus() {
		return addressRecordStatus;
	}

	public void setAddressRecordStatus(String addressRecordStatus) {
		this.addressRecordStatus = addressRecordStatus;
	}
}
