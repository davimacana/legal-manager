package com.legal.manager;

import java.text.SimpleDateFormat;
import java.time.Duration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.legal.manager.entity.Agenda;
import com.legal.manager.entity.Status;
import com.legal.manager.entity.Tipo;
import com.legal.manager.repository.StatusRepository;
import com.legal.manager.repository.TipoRepository;
import com.legal.manager.service.AgendaService;

@Configuration
@EnableScheduling
public class ServletInitializer extends SpringBootServletInitializer implements WebMvcConfigurer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LegalManagerBackApplication.class);
	}

	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
                .allowedHeaders("*");
    }
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.addBasenames("messages");
	    return messageSource;
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	    return builder.setConnectTimeout(Duration.ofMillis(300000)).setReadTimeout(Duration.ofMillis(300000)).build();
	}
	
	@Bean
	public CommandLineRunner demo(AgendaService agendaService, TipoRepository tipoRepository, StatusRepository statusRepository) {
		return (args) -> {
			
			Tipo escritorio = new Tipo("Escritório");
			tipoRepository.save(escritorio);
			Tipo cliente = new Tipo("Cliente");
			tipoRepository.save(cliente);
			Tipo cartorio = new Tipo("Cartório");
			tipoRepository.save(cartorio);
			Tipo forum = new Tipo("Fórum");
			tipoRepository.save(forum);
			
			Status email = new Status("Enviar e-mail");
			statusRepository.save(email);
			Status agendarCartorio = new Status("Agendar cartório");
			statusRepository.save(agendarCartorio);
			Status enviadoForum = new Status("Enviado ao fórum");
			statusRepository.save(enviadoForum);
			Status tese = new Status("Criar tese");
			statusRepository.save(tese);
			
			Agenda agenda = new Agenda(escritorio, "Agenda tipo escritório", null, new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"), null);
			agendaService.add(agenda);
			agenda = new Agenda(cliente, "Agenda tipo cliente", null, new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"), null);
			agendaService.add(agenda);
			agenda = new Agenda(cartorio, "Agenda tipo cartório", null, new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"), null);
			agendaService.add(agenda);
			agenda = new Agenda(forum, "Agenda tipo fórum", null, new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2020"), null);
			agendaService.add(agenda);
		};
	}
}
