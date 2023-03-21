package com.ktbsoln.project_biller.service;

import java.util.List;

import com.ktbsoln.project_biller.dto.ProductCatagoryDto;
import com.ktbsoln.project_biller.dto.ProductDto;
import com.ktbsoln.project_biller.dto.ProductDto2;
import com.ktbsoln.project_biller.entity.ProductCatagoryVO;

public interface ProductService {
	
	String saveOrUpdate(ProductCatagoryDto productCatagoryDto, Long orgId);
	List<ProductCatagoryVO> getAllProductCatagoryByOrgId(Long orgId);
	List<ProductDto2> getAllProducts(Long orgId);
	String saveProduct(ProductDto productDto, Long orgId);
	String updateProduct(ProductDto2 productDto, Long orgId);
}
