/**
 * 
 */
package com.legal.manager.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.legal.manager.api.forum.ClientAPIForum;
import com.legal.manager.entity.Agenda;
import com.legal.manager.entity.Status;
import com.legal.manager.repository.AgendaRepository;
import com.legal.manager.repository.StatusRepository;
import com.legal.manager.service.AgendaService;
import com.legal.manager.util.Messages;

/**
 * @author Davi Maçana
 *
 */
@Service
public class AgendaServiceImpl implements AgendaService {
	
	@Autowired
	private Messages messages;

	@Autowired
	private AgendaRepository agendaRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private ClientAPIForum clientForum;
	
	public static final String ESCRITORIO = "Escritório";
	public static final String CLIENTE = "Cliente";
	public static final String CARTORIO = "Cartório";
	public static final String FORUM = "Fórum";
	
	@Override
	public Iterable<Agenda> findAllPageable(String page, String size) {
		Pageable pageable = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size),
				Sort.by(messages.get("agenda.dataAgenda")));
		return agendaRepository.findAll(pageable);
	}

	@Override
	public Agenda add(Agenda agenda) {
		defineDateStatus(agenda);
		return agendaRepository.save(agenda);
	}
	
	public void defineDateStatus(Agenda agenda) {
		Calendar dataInicio = Calendar.getInstance();
		
		Iterable<Status> listaStatus = statusRepository.findAll();
		switch (agenda.getTipo().getNome()) {
			case ESCRITORIO:
				agenda.setDataInicio(agenda.getDataAgenda());
				break;
			case CLIENTE:
				dataInicio.setTime(agenda.getDataAgenda());
				dataInicio.add(Calendar.DATE, -1);
				agenda.setDataInicio(dataInicio.getTime());
				listaStatus.forEach(status -> {
					if(status.getNome().equalsIgnoreCase(messages.get("status.e-mail"))) {
						agenda.setStatus(status);	
					}
				});
				break;
			case CARTORIO:
				dataInicio.setTime(agenda.getDataAgenda());
				dataInicio.add(Calendar.DATE, -2);
				agenda.setDataInicio(dataInicio.getTime());
				listaStatus.forEach(status -> {
					if(status.getNome().equalsIgnoreCase(messages.get("status.cartorio"))) {
						agenda.setStatus(status);
					}
				});
				break;
			case FORUM:
				dataInicio.setTime(agenda.getDataAgenda());
				dataInicio.add(Calendar.DATE, -3);
				agenda.setDataInicio(dataInicio.getTime());
				listaStatus.forEach(status -> {
					if(status.getNome().equalsIgnoreCase(messages.get("status.forum"))) {
						agenda.setStatus(status);
					}
				});
				clientForum.postAgendamentoForum(agenda);
				break;
			default:
				break;
		}
	}
	
}
