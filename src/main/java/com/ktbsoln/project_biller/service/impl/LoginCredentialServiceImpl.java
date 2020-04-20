package com.ktbsoln.project_biller.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ktbsoln.project_biller.dto.LoginCredentialDto;
import com.ktbsoln.project_biller.entity.LoginCredentialVO;
import com.ktbsoln.project_biller.repository.LoginCredentialRepository;
import com.ktbsoln.project_biller.service.LoginCredentialService;
import com.ktbsoln.project_biller.utils.PBillerEncryptionDecryption;
import com.ktbsoln.project_biller.utils.PBillerConstants;

@Service
public class LoginCredentialServiceImpl implements LoginCredentialService{

	@Autowired private LoginCredentialRepository loginCredentialRepo;
	
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
	
}
