package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.Contrato;

/**
 * Formación - Hibernate - Taller Práctico 2
 * 
 * Interfaz Servicios de Contratos
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
public interface ContratoManagementServiceI {
	/**
	 * Inserta un nuevo Contrato
	 * 
	 * @param newContrato Contrato que queremos insertar
	 */
	public void insertContrato(final Contrato newContrato);

	/**
	 * Actualiza un Contrato
	 * 
	 * @param updatedContrato Contrato que queremos actualizar
	 */
	public void updateContrato(final Contrato updatedContrato);

	/**
	 * Elimina un Contrato
	 * 
	 * @param deletedContrato Contrato que queremos eliminar
	 */
	public void deleteContrato(final Contrato deletedContrato);

	/**
	 * Busca un Contrato por su ID
	 * 
	 * @param contratoId ID del Contrato que queremos sacar
	 * @return Contrato de la base de datos con el id
	 */
	public Contrato searchById(final Long contratoId);


	/**
	 * Busca todos los Contratos
	 *
	 * @return List con todos los Contratos
	 */
	public List<Contrato> searchAll();
	
	
	/**
	 * Busca todos los clientes con contratos caducados
	 * 
	 * @return List con los clientes que tengan algun contrato caducado
	 */
	public List<Cliente> searchByClienteConContratosCaducados(String actualDate);
	
}
