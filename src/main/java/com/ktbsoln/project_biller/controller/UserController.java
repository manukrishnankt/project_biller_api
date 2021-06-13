package com.ktbsoln.project_biller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ktbsoln.project_biller.config.service.AuthUserDetailsService;
import com.ktbsoln.project_biller.dto.UserDto;

@RestController
@RequestMapping(value= "coreapi/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private AuthUserDetailsService authUserDetailService;
	
	@PostMapping("/user")
	public ResponseEntity<String> catagoryMaintanance(@RequestBody UserDto  userDto, @RequestHeader("x-pbiller-orgid") Long orgId) {
		return  ResponseEntity.ok(authUserDetailService.saveUser(userDto, orgId));
	}
}
