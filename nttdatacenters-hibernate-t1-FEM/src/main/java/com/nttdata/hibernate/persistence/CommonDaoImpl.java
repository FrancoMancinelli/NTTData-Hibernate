package com.nttdata.hibernate.persistence;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;

/**
 * Formaci�n - Hibernate - Taller Pr�ctico 1
 * 
 * Clase Abstracta DAO gen�rica
 * 
 * @author NTT Data Sevilla
 *
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesi�n de conexi�n a BD */
	private Session session;

	/**
	 * M�todo constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public CommonDaoImpl(Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	public void insert(final T paramT) {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercci�n.
		session.save(paramT);
		session.flush();

		// Commit.
		session.getTransaction().commit();
	}

	public void update(final T paramT) {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercci�n.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	public void delete(final T paramT) {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercci�n.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	public T searchById(final Long id) {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// B�squeda por PK.
		T result = session.get(this.entityClass, id);

		return result;

	}

	@SuppressWarnings("unchecked")
	public List<T> searchAll() {

		// Verificaci�n de sesi�n abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// B�squeda de todos los registros.
		List<T> list = session.createQuery("FROM " + this.entityClass.getName()).list();

		return list;

	}

	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

}
