package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.ClienteDaoI;
import com.nttdata.hibernate.persistence.ClienteDaoImpl;

/**
 * Formación - Hibernate - Taller Práctico 1
 * 
 * Clase Servicios de Cliente
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
public class ClienteManagementServiceImpl implements ClienteManagementServiceI {

	/** Cliente DAO */
	private ClienteDaoI clienteDao;

	/**
	 * Constructor
	 */
	public ClienteManagementServiceImpl(final Session session) {
		this.clienteDao = new ClienteDaoImpl(session);
	}

	/**
	 * Inserta un nuevo Cliente
	 * 
	 * @param insertCliente Cliente a insertar
	 */
	public void insertCliente(final Cliente insertCliente) {

		// Verificación de nulidad e inexistencia.
		if (insertCliente != null && insertCliente.getId() == null) {

			// Inserta al cliente
			clienteDao.insert(insertCliente);
		}
	}

	/**
	 * Actualiza un Cliente
	 * 
	 * @param updatedClient Cliente a actualizar
	 */
	public void updateCliente(final Cliente updatedCliente) {

		// Verificación de nulidad e inexistencia.
		if (updatedCliente != null && updatedCliente.getId() != 0) {

			// Actualiza al cliente
			clienteDao.update(updatedCliente);
		}
	}

	/**
	 * Elimina un Cliente
	 * 
	 * @param deletedClient Cliente a eliminar
	 */
	public void deleteCliente(final Cliente deletedCliente) {

		// Verificación de nulidad e inexistencia.
		if (deletedCliente != null && deletedCliente.getId() != 0) {

			// Elimina al cliente
			clienteDao.delete(deletedCliente);
		}
	}

	/**
	 * Busca un Cliente por su ID
	 * 
	 * @param clientId ID del cliente a buscar
	 * @return Cliente cliente con ese ID
	 */
	public Cliente searchById(final Long clienteId) {
		Cliente cliente = null;

		// Si el id es diferente de 0
		if (clienteId != 0) {

			// Cliente con ese ID
			cliente = clienteDao.searchById(clienteId);
		}
		return cliente;
	}

	/**
	 * Busca todos los clientes
	 *
	 * @return List listado con todos los clientes
	 */
	public List<Cliente> searchAll() {
		return clienteDao.searchAll();
	}

	/**
	 * Busca los clientes por DNI
	 * 
	 * @param dni El DNI del cliente que queremos sacar
	 * @return List<Cliente> lista de los clientes con ese DNI
	 */
	public List<Cliente> searchByDNI(final String dni) {
		List<Cliente> cliente = new ArrayList<>();

		// Si el dni tiene 9 digitos
		if (dni.length() == 9) {

			// Clientes con ese DNI
			cliente = clienteDao.searchByDNI(dni);
		}
		return cliente;
	}

	/**
	 * Busca los clientes por letra del DNI
	 * 
	 * @param letraDNI la letra a buscar en el DNI
	 * @return List<Cliente> lista de los clientes que tengan esa letra al final de su DNI
	 */
	public List<Cliente> searchByLetraDNI(final String letraDNI) {
		List<Cliente> clientes = new ArrayList<>();

		// Si la letra no es null y es de solo una letra
		if (digitoValido(letraDNI)) {

			// Clientes con esa letra en el DNI
			clientes = clienteDao.searchByLetraDNI(letraDNI);
		}
		return clientes;

	}

	/**
	 * Busca los clientes según las iniciales de sus nombres y primer apellido
	 * 
	 * @param inicialNombre    la letra inicial del nombre
	 * @param inicialApellido1 la letra inicial del primer apellido
	 * @return List<Cliente> lista de los clientes que tengan esas iniciales
	 */
	public List<Cliente> searchByIniciales(final String inicialNombre, final String inicialApellido1) {
		List<Cliente> clientes = new ArrayList<>();

		// Si ls iniciales son validas
		if (digitoValido(inicialNombre) && digitoValido(inicialApellido1)) {

			// Clientes con esas iniciales
			clientes = clienteDao.searchByIniciales(inicialNombre, inicialApellido1);

		}
		return clientes;
	}

	/**
	 * Comprueba que un string no sea null y sea de un solo digito
	 * 
	 * @param string String a comprobar
	 * @return True en caso de no ser null y ser de un solo digito | False en caso contrario
	 */
	private boolean digitoValido(final String string) {
		return string != null && !string.isBlank() && string.length() == 1;
	}

	/**
	 * Busca todos los clientes según su primer y segundo apellido completos
	 * 
	 * @param primerApellido  El primer apellido del cliente
	 * @param segundoApellido El segundo apellido del cliente (null)
	 * @return List<Cliente> Listado con los clientes que tengan esos apellidos
	 */
	public List<Cliente> searchByApellidos(final String primerApellido, final String segundoApellido) {
		List<Cliente> clientes = new ArrayList<>();

		// Si el primer apellido no es null
		// Se tiene en cuenta que no todos tienen segundo apellido, por lo que esté, si
		// puede ser null
		if (primerApellido != null && !primerApellido.isBlank())

			// Clientes con esa letra en el DNI
			clientes = clienteDao.searchByApellidos(primerApellido, segundoApellido);

		return clientes;

	}

}
