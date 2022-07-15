package com.ktbsoln.project_biller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktbsoln.project_biller.dto.ProductCatagoryDto;
import com.ktbsoln.project_biller.dto.ProductDto2;
import com.ktbsoln.project_biller.entity.ProductCatagoryVO;
import com.ktbsoln.project_biller.service.ProductService;

@RestController
@RequestMapping(value = "coreapi/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/catagory")
	public ResponseEntity<String> catagoryMaintanance(@RequestBody ProductCatagoryDto  productCatagoryDto, @RequestHeader("x-pbiller-orgid") Long orgId) {
		return  ResponseEntity.ok(productService.saveOrUpdate(productCatagoryDto, orgId));
	}
	@GetMapping("/catagory")
	public ResponseEntity<List<ProductCatagoryVO>> getAllProductCatagoryByOrgId(@RequestHeader("x-pbiller-orgid") Long orgId) {
		return  ResponseEntity.ok(productService.getAllProductCatagoryByOrgId(orgId));
	}
	@GetMapping("/product")
	public ResponseEntity<List<ProductDto2>> getAllProducts(@RequestHeader("x-pbiller-orgid") Long orgId) {
		return  ResponseEntity.ok(productService.getAllProducts(orgId));
	}
}