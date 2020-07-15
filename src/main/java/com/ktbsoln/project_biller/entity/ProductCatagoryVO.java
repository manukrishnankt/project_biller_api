package com.ktbsoln.project_biller.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_catagory")
public class ProductCatagoryVO {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="pro_catagory_id")
    private Long proCatagoryId;
    
    @Column(name="pro_catagory_name")
    private String proCatagoryName;

    @Column(name="pro_catagory_date_created")
    private Timestamp proCatagoryDateCreated;
    
    @Column(name="pro_catagory_recordstatus")
    private String proCatagoryRecordStatus;
    
    @Column(name="pro_catagory_description")
    private String proCatagoryDescription;

    @Column(name="pro_catagory_companyId")
    private String proCatagoryCompanyId;
    
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

	public String getProCatagoryCompanyId() {
		return proCatagoryCompanyId;
	}

	public void setProCatagoryCompanyId(String proCatagoryCompanyId) {
		this.proCatagoryCompanyId = proCatagoryCompanyId;
	}
    
	
}
