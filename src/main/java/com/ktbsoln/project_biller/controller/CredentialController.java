package com.ktbsoln.project_biller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktbsoln.project_biller.dto.LoginCredentialDto;
import com.ktbsoln.project_biller.service.LoginCredentialService;

@RestController
@RequestMapping(value= "/login")
public class CredentialController {
	@Autowired private LoginCredentialService loginCredentialService;
	
	@PostMapping("/checkCredntial")
	public ResponseEntity<LoginCredentialDto> checkLoginCredntial (LoginCredentialDto loginCredential){
		return ResponseEntity.ok(loginCredentialService.checkCredential(loginCredential));
	}
}
