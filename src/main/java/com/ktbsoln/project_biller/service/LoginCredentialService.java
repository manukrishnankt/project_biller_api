package com.ktbsoln.project_biller.service;

import com.ktbsoln.project_biller.dto.LoginCredentialDto;

public interface LoginCredentialService {
	LoginCredentialDto checkCredential(String loginCredentialDto);
	LoginCredentialDto getUserAndComapnyDetails(String loginCredentialComapnyName, String userName);
}
