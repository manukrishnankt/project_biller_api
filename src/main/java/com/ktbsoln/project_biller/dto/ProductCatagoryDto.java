package com.ktbsoln.project_biller.dto;

import java.sql.Timestamp;

public class ProductCatagoryDto {

    private Long proCatagoryId;
    private String proCatagoryName;
    private Timestamp proCatagoryDateCreated;
    private String proCatagoryRecordStatus;
    private String proCatagoryDescription;
    private String action;
    private Long proCatagoryCompanyCreatedUserId;
    
	public Long getProCatagoryId() {
		return proCatagoryId;
	}
	public void setProCatagoryId(Long proCatagoryId) {
		this.proCatagoryId = proCatagoryId;
	}
	public String getProCatagoryName() {
		return proCatagoryName;
	}
	public void setProCatagoryName(String proCatagoryName) {
		this.proCatagoryName = proCatagoryName;
	}
	public Timestamp getProCatagoryDateCreated() {
		return proCatagoryDateCreated;
	}
	public void setProCatagoryDateCreated(Timestamp proCatagoryDateCreated) {
		this.proCatagoryDateCreated = proCatagoryDateCreated;
	}
	public String getProCatagoryRecordStatus() {
		return proCatagoryRecordStatus;
	}
	public void setProCatagoryRecordStatus(String proCatagoryRecordStatus) {
		this.proCatagoryRecordStatus = proCatagoryRecordStatus;
	}
	public String getProCatagoryDescription() {
		return proCatagoryDescription;
	}
	public void setProCatagoryDescription(String proCatagoryDescription) {
		this.proCatagoryDescription = proCatagoryDescription;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Long getProCatagoryCompanyCreatedUserId() {
		return proCatagoryCompanyCreatedUserId;
	}
	public void setProCatagoryCompanyCreatedUserId(Long proCatagoryCompanyCreatedUserId) {
		this.proCatagoryCompanyCreatedUserId = proCatagoryCompanyCreatedUserId;
	}
}
