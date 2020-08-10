/**
 * 
 */
package com.legal.manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.legal.manager.entity.Agenda;

/**
 * @author Davi Maçana
 *
 */
public interface AgendaRepository extends CrudRepository<Agenda, Long> {
	
	Page<Agenda> findAll(Pageable pageable);
}
