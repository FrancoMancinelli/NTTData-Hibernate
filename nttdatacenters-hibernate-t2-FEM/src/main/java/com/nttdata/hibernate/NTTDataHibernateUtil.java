package com.nttdata.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Formaci�n - Hibernate - Taller Pr�ctico 2
 * 
 * Clase de configuraci�n
 * 
 * @author NTT Data Sevilla
 *
 */
public class NTTDataHibernateUtil {

	/** Factor�a de sesiones */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Constructor privado.
	 */
	private NTTDataHibernateUtil() {

	}

	/**
	 * Generaci�n de factor�a de sesiones.
	 */
	static {

		try {

			// Generaci�n de configuraci�n.
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Exception ex) {

			// Error de inicializaci�n.
			System.err.println("[ERROR] Configuraci�n de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}

	}

	/**
	 * Retorna la factor�a de sesiones.
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
