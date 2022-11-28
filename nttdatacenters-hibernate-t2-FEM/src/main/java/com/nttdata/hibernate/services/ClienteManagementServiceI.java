package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Cliente;

/**
 * Formación - Hibernate - Taller Práctico 2
 * 
 * Interfaz Servicios de Cliente
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
public interface ClienteManagementServiceI {
	/**
	 * Inserta un nuevo Cliente
	 * 
	 * @param newClient Cliente que queremos insertar
	 */
	public void insertCliente(final Cliente newCliente);

	/**
	 * Actualiza un Cliente
	 * 
	 * @param updatedClient Cliente que queremos actualizar
	 */
	public void updateCliente(final Cliente updatedCliente);

	/**
	 * Elimina un Cliente
	 * 
	 * @param deletedClient Cliente que queremos eliminar
	 */
	public void deleteCliente(final Cliente deletedCliente);

	/**
	 * Busca un Cliente por su ID
	 * 
	 * @param clientId ID del cliente que queremos sacar
	 * @return Cliente de la base de datos con el id
	 */
	public Cliente searchById(final Long clienteId);


	/**
	 * Busca todos los Clientes
	 *
	 * @return List con todos los clientes
	 */
	public List<Cliente> searchAll();
	
	/**
	 * Busca en la base de datos todos los clientes que tengan ese DNI
	 * 
	 * @param dni El DNI a buscar
	 * @return La lista con los clientes que cuenten con ese DNI
	 */
	public List<Cliente> searchByDNI(final String dni);
	
	/**
	 * Busca en la base de datos todos los clientes que contengan en su DNI
	 * la letra indicada por parametro
	 * 
	 * @param letraDNI la letra del DNI
	 * 
	 * @return Lista de clientes con esa letra en el DNI
	 */
	public List<Cliente> searchByLetraDNI(final String letraDNI);
	
	/**
	 * Busca los clientes por sus iniciales, tanto del nombr como del primer apellido
	 * 
	 * @param inicialNombre La letra inicial del nombre
	 * @param inicialApellido1 La letra inicial del primer apellido
	 * 
	 * @return Lista de clientes que cuenten con esas iniciales
	 */
	public List<Cliente> searchByIniciales(final String inicialNombre, final String inicialApellido1);
	
	/**
	 * Busca los clientes por sus apellidos
	 * 
	 * @param primerApellido El primer apellido del cliente
	 * @param segundoApellido El segundo apellido del cliente
	 * 
	 * @return Lista de clientes que cuenten con esos dos apellidos
	 */
	public List<Cliente> searchByApellidos(final String primerApellido, final String segundoApellido);

}