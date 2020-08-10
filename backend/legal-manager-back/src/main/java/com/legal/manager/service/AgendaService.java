/**
 * 
 */
package com.legal.manager.service;

import com.legal.manager.entity.Agenda;

/**
 * @author Davi Maçana
 *
 */
public interface AgendaService {
	Iterable<Agenda> findAllPageable(String page, String size);
	Agenda add(Agenda agenda);
}
