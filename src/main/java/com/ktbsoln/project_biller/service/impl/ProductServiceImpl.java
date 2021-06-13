package com.ktbsoln.project_biller.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

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
	public String saveOrUpdate(ProductCatagoryDto productCatagoryDto, Long orgid) {
		String response ="";
		if(productCatagoryDto != null) {
			Gson g = new Gson();
			String json = g.toJson(productCatagoryDto);
			ProductCatagoryVO productCatagoryVO = new Gson().fromJson(json, ProductCatagoryVO.class);
			if(PBillerConstants.PBILLER_DB_OP_INSERT.equals(productCatagoryDto.getAction())) {
				Set<ProductCatagoryVO> productList = listByProductNameandOrgId(productCatagoryVO.getProCatagoryName(), orgid);
				if (productList.size() == 0) {
					productCatagoryVO.setProCatagoryCompanyId(orgid);
					productCatagoryVO.setProCatagoryRecordStatus(PBillerConstants.RECORD_STATUS_ACTIVE);
					productCatagoryVO.setProCatagoryDateCreated(new Timestamp(System.currentTimeMillis()));
					productCatagoryRepository.save(productCatagoryVO);
					response = "{\"STATUS\":\"OK\",\"DESCRIPTION\":\"PRODUCT CATAGORY SAVED SUCCESSFULLY\"}";
				} else {
					response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\"PRODUCT CATAGORY NAME ALREADY EXISTS\"}";
				}
			}
			
		}
		return response;
	}

	private Set<ProductCatagoryVO> listByProductNameandOrgId(String proCatagoryName, Long orgid) {
		return productCatagoryRepository.findByProCatagoryNameProCatagoryCompanyId(proCatagoryName, orgid);
	}

	@Override
	public List<ProductCatagoryVO> getAllProductCatagoryByOrgId(Long orgId) {
		return productCatagoryRepository.findByProCatagoryCompanyId(orgId);
	}
}
