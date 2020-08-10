/**
 * 
 */
package com.legal.manager.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Davi Maçana
 *
 */
@Entity
public class Agenda implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Agenda() {
		super();
	}

	public Agenda(Tipo tipo, String descricao, Date dataInicio, Date dataAgenda, Status status) {
		super();
		this.Tipo = tipo;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataAgenda = dataAgenda;
		this.Status = status;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String descricao;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataAgenda;

	@OneToOne
	private Tipo Tipo;
	
	@OneToOne
	private Status Status;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the tipo
	 */
	public Tipo getTipo() {
		return Tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Tipo tipo) {
		Tipo = tipo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return the dataAgenda
	 */
	public Date getDataAgenda() {
		return dataAgenda;
	}

	/**
	 * @param dataAgenda the dataAgenda to set
	 */
	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return Status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		Status = status;
	}
}
