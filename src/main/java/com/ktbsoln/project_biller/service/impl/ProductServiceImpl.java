package com.ktbsoln.project_biller.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ktbsoln.project_biller.dto.ProductCatagoryDto;
import com.ktbsoln.project_biller.entity.ProductCatagoryVO;
import com.ktbsoln.project_biller.repository.ProductCatagoryRepository;
import com.ktbsoln.project_biller.service.ProductService;
import com.ktbsoln.project_biller.utils.PBillerConstants;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductCatagoryRepository productCatagoryRepository;

	@Override
	public String saveOrUpdate(ProductCatagoryDto productCatagoryDto) {
		String response ="";
		if(productCatagoryDto != null) {
			Gson g = new Gson();
			String json = g.toJson(productCatagoryDto);
			ProductCatagoryVO productCatagoryVO = new Gson().fromJson(json, ProductCatagoryVO.class);
			if(PBillerConstants.PBILLER_DB_OP_INSERT.equals(productCatagoryDto.getAction())) {
				productCatagoryVO.setProCatagoryDateCreated(new Timestamp(System.currentTimeMillis()));
				productCatagoryRepository.save(productCatagoryVO);
				response = "{\"STATUS\":\"OK\",\"DESCRIPTION\":\"PRODUCT CATAGORY SAVED SUCCESSFULLY\"}";
			}
			
		}
		return response;
	}
	
	
	
}
