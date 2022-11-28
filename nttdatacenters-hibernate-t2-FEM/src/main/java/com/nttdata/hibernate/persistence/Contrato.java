package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - Taller Práctico 2
 * 
 * Clase Contrato representativda de una entidad de la tabla NTTDATA_CONTRATOS
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
@Entity
@Table(name = "NTTDATA_CONTRATOS")
public class Contrato extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Identificador (PK) */
	private Long contratoId;
	
	/** Fecha de vigencia del contrato */
	private String fechaVigencia;
	
	/** Fecha de caducidad del contrato */
	private String fechaCaducidad;
	
	/** Precio mensual del contrato*/
	private double precioMensual;
	
	/** Cliente asociado al contrato */
	private Cliente cliente;

	@Transient
	@Override
	public Long getId() {
		return this.contratoId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRATO_ID")
	public Long getContratoId() {
		return contratoId;
	}
	
	public void setContratoId(Long clienteId) {
		this.contratoId = clienteId;
	}

	@Column(name = "FECHA_VIGENCIA")
	public String getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(String fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	@Column(name = "FECHA_CADUCIDAD")
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	@Column(name = "PRECIO_MENSUAL")
	public double getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(double precioMensual) {
		this.precioMensual = precioMensual;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENTE_ID")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
