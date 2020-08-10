/**
 * 
 */
package com.legal.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legal.manager.entity.Tipo;
import com.legal.manager.repository.TipoRepository;
import com.legal.manager.service.TipoService;

/**
 * @author Davi Maçana
 *
 */
@Service
public class TipoServiceImpl implements TipoService {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Override
	public Iterable<Tipo> findAll() {
		return tipoRepository.findAll();
	}
}
