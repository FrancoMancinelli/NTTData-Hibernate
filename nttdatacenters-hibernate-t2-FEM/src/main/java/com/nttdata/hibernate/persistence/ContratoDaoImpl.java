package com.nttdata.hibernate.persistence;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

/**
 * Formación - Hibernate - Taller Práctico 2
 * 
 * Clase que implementa el DAO Contrato
 * 
 * @author Franco Emanuel Mancinelli
 *  
 */
public class ContratoDaoImpl extends CommonDaoImpl<Contrato> implements ContratoDaoI{

	// La session de la BBDD
		private Session session;
		
	// El criteria builder
		private CriteriaBuilder cb;

		/**
		 * Constructor 
		 * 
		 * @param session Session de la base de datos
		 */
		public ContratoDaoImpl(Session session) {
			super(session);
			this.session = session;
			this.cb = session.getCriteriaBuilder();
		}

		@Override
		public List<Cliente> searchByClienteConContratosCaducados(String actualDate) {
			//Consulta
			final CriteriaQuery<Cliente> cquery = cb.createQuery(Cliente.class);
			final Root<Cliente> rootCliente = cquery.from(Cliente.class);
			final Join<Cliente, Contrato> clienteJoinContrato = rootCliente.join("contratos");
			
			//Where
			final Predicate pr1 = cb.lessThan(clienteJoinContrato.get("fechaCaducidad"), actualDate);
			
			//Consulta
			cquery.select(rootCliente).where(pr1);
			
			return session.createQuery(cquery).getResultList();
			
		}




}
