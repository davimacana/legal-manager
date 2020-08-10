package com.legal.manager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import com.legal.manager.entity.Agenda;
import com.legal.manager.repository.AgendaRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class LegalManagerBackApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AgendaRepository agendaRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void whenListAgendaUsingCorret() throws Exception {
		
		 mockMvc.perform(get("http://localhost:8080/legal-api/agenda"))
        .andExpect(status().isOk())
        .andDo(print());

		 verify(agendaRepository).findAll((Pageable) isA(Pageable.class));
	}

	@Test
	public void whenCreate_thenPersistData () throws ParseException {
	
	    Agenda agenda = new Agenda(null, "Agenda tipo escritório", null, new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"), null);
	    this.agendaRepository.save(agenda);
	
	    assertThat(agenda.getId()).isNotNull();
	    assertThat(agenda.getDescricao()).isEqualTo("Agenda tipo escritório");
	
	}
}
