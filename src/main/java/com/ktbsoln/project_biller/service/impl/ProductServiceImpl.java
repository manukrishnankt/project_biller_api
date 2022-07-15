package com.ktbsoln.project_biller.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ktbsoln.project_biller.dto.ProductCatagoryDto;
import com.ktbsoln.project_biller.entity.LoginCredentialVO;
import com.ktbsoln.project_biller.entity.ProductCatagoryVO;
import com.ktbsoln.project_biller.repository.LoginCredentialRepository;
import com.ktbsoln.project_biller.repository.ProductCatagoryRepository;
import com.ktbsoln.project_biller.service.ProductService;
import com.ktbsoln.project_biller.utils.PBillerConstants;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductCatagoryRepository productCatagoryRepository;
	@Autowired
	private LoginCredentialRepository loginCredentialRepository;

	@Override
	public String saveOrUpdate(ProductCatagoryDto productCatagoryDto, Long orgid) {
		String response ="";
		if(productCatagoryDto != null) {
			if(PBillerConstants.PBILLER_DB_OP_INSERT.equals(productCatagoryDto.getAction())) {
				Gson g = new Gson();
				String json = g.toJson(productCatagoryDto);
				ProductCatagoryVO productCatagoryVO = new Gson().fromJson(json, ProductCatagoryVO.class);
				LoginCredentialVO loginCredentialVO = loginCredentialRepository.findByLoginCredentialId(productCatagoryDto.getProCatagoryCompanyCreatedUserId());
				productCatagoryVO.setProCatagoryCompanyCreatedUser(loginCredentialVO);
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
			} else {
				Optional<ProductCatagoryVO> proCatagoryVOption = productCatagoryRepository.findById(productCatagoryDto.getProCatagoryId());
				if (proCatagoryVOption.isPresent()) {
					ProductCatagoryVO proCatagoryVO = proCatagoryVOption.get();
					proCatagoryVO.setProCatagoryName(productCatagoryDto.getProCatagoryName());
					proCatagoryVO.setProCatagoryDescription(productCatagoryDto.getProCatagoryDescription());
					productCatagoryRepository.save(proCatagoryVO);
					response = "{\"STATUS\":\"OK\",\"DESCRIPTION\":\"PRODUCT CATAGORY UPDATED SUCCESSFULLY\"}";
				} else {
					response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\"PRODUCT CATAGORY COULD NOT BE FOUND!\"}";
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
		return productCatagoryRepository.findByProCatagoryCompanyId(orgId).stream().map(item -> {
			item.getProCatagoryCompanyCreatedUser().setLoginCredentialPassword(null);
			return item;
		}).collect(Collectors.toList());
	}
}
