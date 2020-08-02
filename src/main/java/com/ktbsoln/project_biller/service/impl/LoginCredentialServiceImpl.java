package com.ktbsoln.project_biller.service.impl;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ktbsoln.project_biller.dto.LoginCredentialDto;
import com.ktbsoln.project_biller.entity.CompanyVO;
import com.ktbsoln.project_biller.entity.LoginCredentialVO;
import com.ktbsoln.project_biller.repository.CompanyRepository;
import com.ktbsoln.project_biller.repository.LoginCredentialRepository;
import com.ktbsoln.project_biller.service.LoginCredentialService;
import com.ktbsoln.project_biller.utils.PBillerConstants;
import com.ktbsoln.project_biller.utils.PBillerEncryptionDecryption;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class LoginCredentialServiceImpl implements LoginCredentialService{

	@Autowired private LoginCredentialRepository loginCredentialRepo;
	@Autowired private CompanyRepository companyRepository;
	
	@Override
	public LoginCredentialDto checkCredential(String loginCredentialDto) {
		Gson g = new Gson();
		String json = g.toJson(loginCredentialDto);
		LoginCredentialDto lvo = new Gson().fromJson(json, LoginCredentialDto.class);
		String decryptPassword = PBillerEncryptionDecryption.decrypt(lvo.getLoginCredentialPassword(), PBillerConstants.PBILLER_ENC_DEC_SECRECT_KEY);
		LoginCredentialVO loginCredential = loginCredentialRepo.checkLoginCredential(lvo.getLoginCredentialUserName(), decryptPassword,
				lvo.getLoginCredentialComapnyName());
		lvo = new LoginCredentialDto();
		if(loginCredential !=null) {
			lvo.setLoginCredentialId(loginCredential.getLoginCredentialId());
		}
		return lvo;
	}

	@Override
	public LoginCredentialDto getUserAndComapnyDetails(String loginCredentialComapnyName) throws ObjectNotFoundException {
		JSONObject lCandComapnyName = new JSONObject(loginCredentialComapnyName);
		LoginCredentialDto loginCredentialDto = new LoginCredentialDto();
		if(lCandComapnyName.has("loginCredentialComapnyName") && lCandComapnyName.has("userName")) {
			String companyName = lCandComapnyName.getString("loginCredentialComapnyName");
			String userName = lCandComapnyName.getString("userName");
			CompanyVO companyVO = companyRepository.getComapnyDetails(companyName, userName);
			if(companyVO != null) {
				loginCredentialDto.setLoginCredentialComapnyName(companyVO.getCompanyName());
				loginCredentialDto.setLoginCredentialCompanyId(companyVO.getCompanyId());
				loginCredentialDto.setLoginCredentialUserName(userName);
				loginCredentialDto.setLoginCredentialId(loginCredentialRepo.getUserId(companyName, userName));
			}
		}else {
			throw new ObjectNotFoundException("Company Name and Username is Not Found !!!");
		}
		return loginCredentialDto;
	}
}
