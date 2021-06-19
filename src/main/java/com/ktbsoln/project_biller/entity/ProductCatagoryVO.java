package com.ktbsoln.project_biller.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    private Long proCatagoryCompanyId;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pro_catagory_createdBy", referencedColumnName = "lc_id")
    private LoginCredentialVO proCatagoryCompanyCreatedUser;
    
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

	public Long getProCatagoryCompanyId() {
		return proCatagoryCompanyId;
	}

	public void setProCatagoryCompanyId(Long proCatagoryCompanyId) {
		this.proCatagoryCompanyId = proCatagoryCompanyId;
	}

	public LoginCredentialVO getProCatagoryCompanyCreatedUser() {
		return proCatagoryCompanyCreatedUser;
	}

	public void setProCatagoryCompanyCreatedUser(LoginCredentialVO proCatagoryCompanyCreatedUser) {
		this.proCatagoryCompanyCreatedUser = proCatagoryCompanyCreatedUser;
	}
    
	
}
