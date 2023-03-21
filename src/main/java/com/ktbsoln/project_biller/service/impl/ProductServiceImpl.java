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
import com.ktbsoln.project_biller.dto.ProductDto;
import com.ktbsoln.project_biller.dto.ProductDto2;
import com.ktbsoln.project_biller.entity.LoginCredentialVO;
import com.ktbsoln.project_biller.entity.ProductCatagoryVO;
import com.ktbsoln.project_biller.entity.ProductVO;
import com.ktbsoln.project_biller.repository.LoginCredentialRepository;
import com.ktbsoln.project_biller.repository.ProductCatagoryRepository;
import com.ktbsoln.project_biller.repository.ProductRepository;
import com.ktbsoln.project_biller.service.ProductService;
import com.ktbsoln.project_biller.utils.PBillerConstants;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductCatagoryRepository productCatagoryRepository;
	@Autowired
	private LoginCredentialRepository loginCredentialRepository;
	@Autowired
	private ProductRepository productRepository;
	
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
				Set<ProductCatagoryVO> productList = listByProductCatagoryNameandOrgId(productCatagoryVO.getProCatagoryName(), orgid);
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
					if (!proCatagoryVO.getProCatagoryName().equalsIgnoreCase(productCatagoryDto.getProCatagoryName()) && 
							listByProductCatagoryNameandOrgId(productCatagoryDto.getProCatagoryName(), orgid).size() == 0) {
						proCatagoryVO.setProCatagoryName(productCatagoryDto.getProCatagoryName());
						proCatagoryVO.setProCatagoryDescription(productCatagoryDto.getProCatagoryDescription());
						productCatagoryRepository.save(proCatagoryVO);
						response = "{\"STATUS\":\"OK\",\"DESCRIPTION\":\"PRODUCT CATAGORY UPDATED SUCCESSFULLY\"}";
					} else {
						response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\"PRODUCT CATAGORY NAME ALREADY EXISTS\"}";
						return response;
					}
					
				} else {
					response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\"PRODUCT CATAGORY COULD NOT BE FOUND!\"}";
				}
			}
		}
		return response;
	}

	@Override
	public List<ProductCatagoryVO> getAllProductCatagoryByOrgId(Long orgId) {
		return productCatagoryRepository.findByProCatagoryCompanyId(orgId).stream().map(item -> {
			item.getProCatagoryCompanyCreatedUser().setLoginCredentialPassword(null);
			return item;
		}).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto2> getAllProducts(Long orgId) {
		List<ProductVO> productVoList = productRepository.findByProductCompanyId(orgId);
		return productVoList.stream().map(item -> {
			ProductDto2 prd = new ProductDto2();
			prd.setProductId(item.getProductId());
			prd.setProductName(item.getProductName());
			prd.setProductCatagoryName(item.getProductCatagory().getProCatagoryName());
			prd.setProductCatagoryId(item.getProductCatagory().getProCatagoryId());
			prd.setProductCreatedDate(item.getProductCreatedDate());
			prd.setProductPrice(item.getProductPrice());
			prd.setProductCreatedByName(item.getProductCreatedBy().getLoginCredentialUserName());
			return prd;
		}).collect(Collectors.toList());
	}

	@Override
	public String saveProduct(ProductDto productDto, Long orgId) {
		String response ="";
		ProductVO productVO = new ProductVO();
		LoginCredentialVO loginCredentialVO = loginCredentialRepository.findByLoginCredentialId(productDto.getProductCreatedBy());
		productVO.setProductCreatedBy(loginCredentialVO);
		Set<ProductVO> productList = listByProductNameandOrgId(productDto.getProductName(), orgId);
		if (productList.size() == 0) {
			Optional<ProductCatagoryVO> productCataVOption = productCatagoryRepository.findById(productDto.getProductCatagoryId());
			if (productCataVOption.isPresent()) {
				productVO.setProductCatagory(productCataVOption.get());
				productVO.setProductName(productDto.getProductName());
				productVO.setProductPrice(productDto.getProductPrice());
				productVO.setProductCompanyId(orgId);
				productVO.setProductCreatedDate(new Timestamp(System.currentTimeMillis()));
				productVO.setProductRecordStatus(PBillerConstants.RECORD_STATUS_ACTIVE);
				productRepository.save(productVO);
				response = "{\"STATUS\":\"OK\",\"DESCRIPTION\":\"PRODUCT SAVED SUCCESSFULLY\"}";
			} else {
				response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\"PRODUCT CATAGORY COULD NOT BE FOUND!\"}";
			}
		} else {
			response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\"PRODUCT NAME ALREADY EXISTS\"}";
		}
		return response;
	}

	private Set<ProductCatagoryVO> listByProductCatagoryNameandOrgId(String proCatagoryName, Long orgid) {
		return productCatagoryRepository.findByProCatagoryNameProCatagoryCompanyId(proCatagoryName, orgid);
	}

	private Set<ProductVO> listByProductNameandOrgId(String productName, Long orgId) {
		return productRepository.findByProNameAndCompanyId(productName, orgId);
	}

	@Override
	public String updateProduct(ProductDto2 productDto, Long orgId) {
		String response ="";
		Optional<ProductVO> productVOption = productRepository.findById(productDto.getProductId());
		if (productVOption.isPresent()) {
			ProductVO productVO = productVOption.get();
			if (!productDto.getProductCatagoryId().equals(productVO.getProductCatagory().getProCatagoryId())) {
				Optional<ProductCatagoryVO> producCatagoryVO = productCatagoryRepository.findById(productDto.getProductCatagoryId());
				if (producCatagoryVO.isPresent()) {
					productVO.setProductCatagory(producCatagoryVO.get());
				} else {
					response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\"PRODUCT CATAGORY COULD NOT BE FOUND!\"}";
				}
			}
			if (!productDto.getProductName().equals(productVO.getProductName())) {
				List<ProductVO> prodVO = productRepository.findByProductNameAndProductCompanyId(productDto.getProductName(), orgId);
				if (prodVO.isEmpty()) {
					productVO.setProductName(productDto.getProductName());
				} else {
					response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\"PRODUCT NAME ALREADY EXISTS!\"}";
					return response;
				}
			}
			productVO.setProductDescription(productDto.getProductDescription());
			productVO.setProductLastUpdated(new Timestamp(System.currentTimeMillis()));
			productRepository.save(productVO);
			response = "{\"STATUS\":\"OK\",\"DESCRIPTION\":\"PRODUCT UPDATED SUCCESSFULLY\"}";
		} else {
			response = "{\"STATUS\":\"FAILED\",\"DESCRIPTION\":\"PRODUCT COULD NOT BE FOUND!\"}";
		}
		return response;
	}
}
