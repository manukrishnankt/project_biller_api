package com.ktbsoln.project_biller.service;

import com.ktbsoln.project_biller.dto.LoginCredentialDto;

import javassist.tools.rmi.ObjectNotFoundException;

public interface LoginCredentialService {
	LoginCredentialDto checkCredential(String loginCredentialDto);
	LoginCredentialDto getUserAndComapnyDetails(String loginCredentialComapnyName) throws ObjectNotFoundException;
}
