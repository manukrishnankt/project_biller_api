package com.ktbsoln.project_biller.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class InvoiceController {
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Object greeting() {
		return counter.incrementAndGet();
	}
}