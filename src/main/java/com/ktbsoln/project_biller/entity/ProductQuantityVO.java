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
@Table(name="product_quantity")
public class ProductQuantityVO {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="pq_id")
    private Long productQuantityId;
     
    @Column(name="pq_product_id")
    private Long productQuantityProductId;

    @Column(name="pq_count")
    private Long productQuantityCount;
    
    @Column(name="pq_unit")
    private String productQuantityUnit;
    
    @Column(name="pq_lastupdated")
    private Date productQuantityLastUpdated;
    
    @Column(name="pq_created")
    private Timestamp productQuantityCreatedDate;
    
    @Column(name="pq_record_status")
    private String productQuantityRecordStatus ;

	public Long getProductQuantityId() {
		return productQuantityId;
	}

	public void setProductQuantityId(Long productQuantityId) {
		this.productQuantityId = productQuantityId;
	}

	public Long getProductQuantityProductId() {
		return productQuantityProductId;
	}

	public void setProductQuantityProductId(Long productQuantityProductId) {
		this.productQuantityProductId = productQuantityProductId;
	}

	public Long getProductQuantityCount() {
		return productQuantityCount;
	}

	public void setProductQuantityCount(Long productQuantityCount) {
		this.productQuantityCount = productQuantityCount;
	}

	public String getProductQuantityUnit() {
		return productQuantityUnit;
	}

	public void setProductQuantityUnit(String productQuantityUnit) {
		this.productQuantityUnit = productQuantityUnit;
	}

	public Date getProductQuantityLastUpdated() {
		return productQuantityLastUpdated;
	}

	public void setProductQuantityLastUpdated(Date productQuantityLastUpdated) {
		this.productQuantityLastUpdated = productQuantityLastUpdated;
	}

	public Timestamp getProductQuantityCreatedDate() {
		return productQuantityCreatedDate;
	}

	public void setProductQuantityCreatedDate(Timestamp productQuantityCreatedDate) {
		this.productQuantityCreatedDate = productQuantityCreatedDate;
	}

	public String getProductQuantityRecordStatus() {
		return productQuantityRecordStatus;
	}

	public void setProductQuantityRecordStatus(String productQuantityRecordStatus) {
		this.productQuantityRecordStatus = productQuantityRecordStatus;
	}
}
