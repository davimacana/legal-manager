/**
 * 
 */
package com.legal.manager.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.legal.manager.api.forum.ClientAPIForum;

/**
 * @author Davi Maçana
 *
 */
@Component
public class ScheduleForum {
	
	@Autowired
	private ClientAPIForum clientAPIForum;

	@Scheduled(fixedRate = 1800000)
	public void reportCurrentTime() {
		clientAPIForum.getAgendamentoForum();
	}
}
