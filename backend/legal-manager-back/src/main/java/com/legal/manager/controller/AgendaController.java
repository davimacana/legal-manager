/**
 * 
 */
package com.legal.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legal.manager.entity.Agenda;
import com.legal.manager.service.AgendaService;

/**
 * @author Davi Maçana
 *
 */
@RestController
@RequestMapping(value="/agenda")
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	
	@GetMapping
	public ResponseEntity<?> findAllPageable(String page, String size) {
		return ResponseEntity.ok(agendaService.findAllPageable(page, size));
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Agenda agenda) {
		return ResponseEntity.ok(agendaService.add(agenda));
	} 

}
