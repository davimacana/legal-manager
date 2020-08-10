/**
 * 
 */
package com.legal.manager.api.forum;

import java.text.SimpleDateFormat;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.legal.manager.entity.Agenda;
import com.legal.manager.util.Messages;

/**
 * @author Davi Maçana
 *
 */
@Component
public class ClientAPIForum {
	
	private static final SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Messages messages;
	
	public void postAgendamentoForum(Agenda agenda) {
		
		JSONObject request = new JSONObject();
		request.put("data", stf.format(agenda.getDataAgenda()));
		request.put("descricao", agenda.getDescricao());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
		
		restTemplate.postForEntity(messages.get("api.forum.url"), entity, String.class);
		
	}
	
	public void getAgendamentoForum() {
		
		// ResponseEntity<Agenda> agenda = restTemplate.getForEntity(messages.get("api.forum.url"), Agenda.class);
		
	}
}
