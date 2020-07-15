package com.ktbsoln.project_biller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktbsoln.project_biller.dto.ProductCatagoryDto;
import com.ktbsoln.project_biller.service.ProductService;

@RestController
@RequestMapping(value = "coreapi/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/catagory")
	public ResponseEntity<String> catagoryMaintanance(@RequestBody ProductCatagoryDto  productCatagoryDto) {
		System.out.println("Reached catagoryMaintanance Method ");
		
		return  ResponseEntity.ok(productService.saveOrUpdate(productCatagoryDto));
	}
}