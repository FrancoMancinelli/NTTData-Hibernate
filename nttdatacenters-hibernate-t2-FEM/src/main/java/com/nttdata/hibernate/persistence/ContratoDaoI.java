package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Formaci�n - Hibernate - Taller Pr�ctico 2
 * 
 * Interfaz DAO de Contrato
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
public interface ContratoDaoI extends CommonDaoI<Contrato> {
		
	/**
	 * Busca en la base de datos los contratos que ya hayan vencido
	 *
	 * @return La lista de contratos vencidos
	 */
	public List<Cliente> searchByClienteConContratosCaducados(String actualDate);

}
