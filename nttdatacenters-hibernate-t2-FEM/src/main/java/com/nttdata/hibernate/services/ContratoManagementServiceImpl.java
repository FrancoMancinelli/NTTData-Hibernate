package com.nttdata.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.Contrato;
import com.nttdata.hibernate.persistence.ContratoDaoI;
import com.nttdata.hibernate.persistence.ContratoDaoImpl;

/**
 * Formación - Hibernate - Taller Práctico 2
 * 
 * Clase Servicios de Contrato
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
public class ContratoManagementServiceImpl implements ContratoManagementServiceI{

	/** Contrato DAO */
	private ContratoDaoI contratoDao;
	
	/**
	 * Constructor
	 */
	public ContratoManagementServiceImpl(final Session session) {
		this.contratoDao = new ContratoDaoImpl(session);
	}
	
	/**
	 * Inserta un nuevo Contrato
	 * 
	 * @param insertContrato Contrato a insertar
	 */
	@Override
	public void insertContrato(Contrato newContrato) {
		// Verificación de nulidad e inexistencia.
				if (newContrato != null && newContrato.getId() == null) {

					// Inserta al contrato
					contratoDao.insert(newContrato);
				}		
	}

	/**
	 * Actualiza un Contrato
	 * 
	 * @param updatedContrato Contrato a actualizar
	 */
	@Override
	public void updateContrato(Contrato updatedContrato) {
		// Verificación de nulidad e inexistencia.
		if (updatedContrato != null && updatedContrato.getId() != 0) {

			// Actualiza al contrato
			contratoDao.update(updatedContrato);
		}		
	}

	/**
	 * Elimina un Contrato
	 * 
	 * @param deletedContrato Contrato a eliminar
	 */
	@Override
	public void deleteContrato(Contrato deletedContrato) {
		// Verificación de nulidad e inexistencia.
		if (deletedContrato != null && deletedContrato.getId() != 0) {

			// Elimina al contrato
			contratoDao.delete(deletedContrato);
		}		
	}

	/**
	 * Busca un Contrato por su ID
	 * 
	 * @param contratoId ID del Contrato a buscar
	 * @return Contrato contrato con ese ID
	 */
	@Override
	public Contrato searchById(Long contratoId) {
		Contrato contrato = null;

		// Si el id es diferente de 0
		if (contratoId != 0) {

			// Contrato con ese ID
			contrato = contratoDao.searchById(contratoId);
		}
		return contrato;
	}

	/**
	 * Busca todos los contratos
	 *
	 * @return List listado con todos los contratos
	 */
	@Override
	public List<Contrato> searchAll() {
		return contratoDao.searchAll();
	}
	
	/**
	 * Busca todos los clientes con contratos caducados
	 * 
	 * @return List con los clientes que tengan algun contrato caducado
	 */
	@Override
	public List<Cliente> searchByClienteConContratosCaducados(String actualDate) {
		return contratoDao.searchByClienteConContratosCaducados(actualDate);
	}

}
