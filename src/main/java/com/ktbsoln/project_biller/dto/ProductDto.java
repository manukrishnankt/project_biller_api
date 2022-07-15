package com.ktbsoln.project_biller.dto;

import java.sql.Timestamp;

public class ProductDto {
	private String productName;
	private Long productPrice;
	private String productCatagory;
	private Timestamp productCreatedDate;


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

	public String getProductCatagory() {
		return productCatagory;
	}

	public void setProductCatagory(String productCatagory) {
		this.productCatagory = productCatagory;
	}

	public Timestamp getProductCreatedDate() {
		return productCreatedDate;
	}

	public void setProductCreatedDate(Timestamp productCreatedDate) {
		this.productCreatedDate = productCreatedDate;
	}


}
