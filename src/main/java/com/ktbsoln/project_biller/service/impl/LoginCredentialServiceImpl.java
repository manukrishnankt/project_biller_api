package com.ktbsoln.project_biller.service.impl;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ktbsoln.project_biller.dto.LoginCredentialDto;
import com.ktbsoln.project_biller.entity.LoginCredentialVO;
import com.ktbsoln.project_biller.service.LoginCredentialService;

@Service
public class LoginCredentialServiceImpl implements LoginCredentialService{

	@Override
	public LoginCredentialDto checkCredential(LoginCredentialDto loginCredentialDto) {
		Gson g = new Gson();
		String json = g.toJson(loginCredentialDto);
		LoginCredentialVO lvo = new Gson().fromJson(json, LoginCredentialVO.class);
		return null;
	}
	
}
