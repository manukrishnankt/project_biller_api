package com.ktbsoln.project_biller.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class InvoiceController {
	private final AtomicLong counter = new AtomicLong();

    @PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/greeting")
	public Object greeting() {
		return counter.incrementAndGet();
	}
}