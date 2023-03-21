package com.ktbsoln.project_biller.dto;

import java.sql.Timestamp;

public class ProductDto {
	private String productName;
	private Long productPrice;
	private Long productCatagoryId;
	private Timestamp productCreatedDate;
	private Long productCreatedBy;
	private String productDescription;

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
	
	public Timestamp getProductCreatedDate() {
		return productCreatedDate;
	}

	public void setProductCreatedDate(Timestamp productCreatedDate) {
		this.productCreatedDate = productCreatedDate;
	}

	public Long getProductCreatedBy() {
		return productCreatedBy;
	}

	public void setProductCreatedBy(Long productCreatedBy) {
		this.productCreatedBy = productCreatedBy;
	}

	public Long getProductCatagoryId() {
		return productCatagoryId;
	}

	public void setProductCatagoryId(Long productCatagoryId) {
		this.productCatagoryId = productCatagoryId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}
