package com.ktbsoln.project_biller.dto;

public class ProductDto2 extends ProductDto{
	private Long productId;
	private String productCreatedByName;
	private String productCatagoryName;
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCreatedByName() {
		return productCreatedByName;
	}

	public void setProductCreatedByName(String productCreatedByName) {
		this.productCreatedByName = productCreatedByName;
	}

	public String getProductCatagoryName() {
		return productCatagoryName;
	}

	public void setProductCatagoryName(String productCatagoryName) {
		this.productCatagoryName = productCatagoryName;
	}
	
}
