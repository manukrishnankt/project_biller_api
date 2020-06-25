package com.ktbsoln.project_biller.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/guest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GuestController {
	@GetMapping("/a")
	public ResponseEntity<String> checkLoginCredntial (){
		return ResponseEntity.ok("{\"hello\":\"hello\"}");
	}
	@PostMapping
	public ResponseEntity<String> postCheck (){
		return ResponseEntity.ok("{\"hello\":\"hello\"}");
	}
}
