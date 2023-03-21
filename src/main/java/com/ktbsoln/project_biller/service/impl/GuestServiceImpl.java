package com.ktbsoln.project_biller.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ktbsoln.project_biller.repository.ProductRepository;
import com.ktbsoln.project_biller.service.GuestService;

public class GuestServiceImpl implements GuestService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Object getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
