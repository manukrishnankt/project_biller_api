package com.ktbsoln.project_biller.controller;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktbsoln.project_biller.dto.LoginCredentialDto;
import com.ktbsoln.project_biller.service.LoginCredentialService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value= "/credential")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CredentialController {
	@Autowired
	private LoginCredentialService loginCredentialService;
	private final AtomicLong counter = new AtomicLong();
	
	@PostMapping("/checkCredntial")
	public ResponseEntity<LoginCredentialDto> checkLoginCredntial (String loginCredential){
		return ResponseEntity.ok(loginCredentialService.checkCredential(loginCredential));
	}
	
	@GetMapping("/whoami")
	public String whoami(@AuthenticationPrincipal String name) {
		return name;
    }
	@PostMapping(value ="/getUserAndComapnyDetails", consumes =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginCredentialDto> getUserAndComapnyDetails(@RequestBody String userNameAndCompanyName) throws ObjectNotFoundException {
		return ResponseEntity.ok(loginCredentialService.getUserAndComapnyDetails(userNameAndCompanyName));
    }
	
	@GetMapping("/me")
    public ResponseEntity<Principal> get(final Principal principal) {
        return ResponseEntity.ok(principal);
    }
	
	@GetMapping("/greeting")
	public Object greeting() {
		return counter.incrementAndGet();
	}
}
