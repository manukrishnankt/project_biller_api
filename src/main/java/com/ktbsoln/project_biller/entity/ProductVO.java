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
@Table(name = "product")
public class ProductVO {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_price")
	private Long productPrice;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_catagory_id", referencedColumnName = "pro_catagory_id")
	private ProductCatagoryVO productCatagory;
	
	@Column(name = "product_company_id")
	private Long productCompanyId;

	@Column(name = "product_lastupdated")
	private String productLastUpdated;
	
	@Column(name = "product_created")
	private Timestamp productCreatedDate;

	@Column(name = "product_record_status")
	private String productRecordStatus;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}

	public Long getProductCompanyId() {
		return productCompanyId;
	}

	public void setProductCompanyId(Long productCompanyId) {
		this.productCompanyId = productCompanyId;
	}

	public ProductCatagoryVO getProductCatagory() {
		return productCatagory;
	}

	public void setProductCatagory(ProductCatagoryVO productCatagory) {
		this.productCatagory = productCatagory;
	}

	public String getProductLastUpdated() {
		return productLastUpdated;
	}

	public void setProductLastUpdated(String productLastUpdated) {
		this.productLastUpdated = productLastUpdated;
	}

	public Timestamp getProductCreatedDate() {
		return productCreatedDate;
	}

	public void setProductCreatedDate(Timestamp productCreatedDate) {
		this.productCreatedDate = productCreatedDate;
	}

	public String getProductRecordStatus() {
		return productRecordStatus;
	}

	public void setProductRecordStatus(String productRecordStatus) {
		this.productRecordStatus = productRecordStatus;
	}
	
}
