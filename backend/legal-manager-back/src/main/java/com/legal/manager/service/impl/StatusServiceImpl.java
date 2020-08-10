/**
 * 
 */
package com.legal.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legal.manager.entity.Status;
import com.legal.manager.repository.StatusRepository;
import com.legal.manager.service.StatusService;

/**
 * @author Davi Maçana
 *
 */
@Service
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Override
	public Iterable<Status> findAll() {
		return statusRepository.findAll();
	}
}
