package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Formaci�n - Hibernate - Taller Pr�ctico 2
 * 
 * Clase que implementa el DAO Cliente
 * 
 * @author Franco Emanuel Mancinelli
 *  
 */
public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {

	// La session de la BBDD
	private Session session;

	/**
	 * Constructor 
	 * 
	 * @param session Session de la base de datos
	 */
	public ClienteDaoImpl(Session session) {
		super(session);
		this.session = session;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> searchByDNI(final String dni) {
		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}		
		return session.createQuery("FROM Cliente WHERE dni = '" + dni + "'").list();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> searchByLetraDNI(final String letraDNI) {
		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}		
		
		return session.createQuery("FROM Cliente WHERE dni LIKE '%" + letraDNI + "'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> searchByIniciales(final String inicialNombre, final String inicialApellido1) {
		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}		
		
		return session.createQuery("FROM Cliente WHERE nombre LIKE '"+inicialNombre+"%' AND primerApellido LIKE '"+inicialApellido1+"%'").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> searchByApellidos(final String primerApellido, final String segundoApellido) {
		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}		
		
		return session.createQuery("FROM Cliente WHERE primerApellido = '"+primerApellido+"' AND segundoApellido = '"+segundoApellido+"'").list();
	}
}
