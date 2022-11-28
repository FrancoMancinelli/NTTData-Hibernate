package com.nttdata.hibernate.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Formación - Hibernate - Taller Práctico 1
 * 
 * Clase Cliente representativda de una entidad de la tabla NTTDATA_CLIENTES
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
@Entity
@Table(name = "NTTDATA_CLIENTES")
public class Cliente extends AbstractEntity implements Serializable {
	
	/** Serial Version */
	private static final long serialVersionUID = 1L;
	
	/** Identificador (PK) */
	private Long clienteId;
	
	/** Nombre del cliente */
	private String nombre;
	
	/** Primer Apellido del cliente */
	private String primerApellido;
	
	/** Segundo Apellido del cliente*/
	private String segundoApellido;
	
	/** DNI del cliente*/
	private String dni;

	@Transient
	@Override
	public Long getId() {
		return this.clienteId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENTE_ID")
	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "PRIMER_APELLIDO")
	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String apellido) {
		this.primerApellido = apellido;
	}

	@Column(name = "SEGUNDO_APELLIDO")
	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	@Column(name = "DNI", nullable = false, unique = true)
	@Max(value = 9, message = "Error, el DNI debe tener 9 digitos")
	@Min(value = 9, message = "Error, el DNI debe tener 9 digitos")
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Cliente [clienteId=" + clienteId + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", dni=" + dni + "]";
	}

}
