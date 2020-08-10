/**
 * 
 */
package com.legal.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legal.manager.service.TipoService;

/**
 * @author Davi Maçana
 *
 */
@RestController
@RequestMapping(value="/tiposAgenda")
public class TipoController {
	
	@Autowired
	private TipoService tipoService;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(tipoService.findAll());
	}

}
