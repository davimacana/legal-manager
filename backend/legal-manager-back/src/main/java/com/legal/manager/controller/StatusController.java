/**
 * 
 */
package com.legal.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legal.manager.service.StatusService;

/**
 * @author Davi Maçana
 *
 */
@RestController
@RequestMapping(value="/statusAgenda")
public class StatusController {
	
	@Autowired
	private StatusService statusService;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(statusService.findAll());
	}

}
