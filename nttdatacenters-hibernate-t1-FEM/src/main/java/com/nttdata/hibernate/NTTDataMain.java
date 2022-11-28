package com.nttdata.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.services.ClienteManagementServiceI;
import com.nttdata.hibernate.services.ClienteManagementServiceImpl;

/**
 * Formación - Hibernate - Taller Práctio 1
 * 
 * Clase principal
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
public class NTTDataMain {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClienteManagementServiceI clienteService = new ClienteManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "NTT_FRANCO_M";
		
		// Creación de Clientes e Inserción a la BD
		Cliente c1 = new Cliente();
		c1.setNombre("Antonio");
		c1.setPrimerApellido("Alvarez");
		c1.setSegundoApellido("Almiron");
		c1.setDni("11111111A");
		c1.setUpdatedUser(updatedUser);
		clienteService.insertCliente(c1);
		
		Cliente c2 = new Cliente();
		c2.setNombre("Bianca");
		c2.setPrimerApellido("Bolaño");
		c2.setSegundoApellido(null);
		c2.setDni("22222222B");
		c2.setUpdatedUser(updatedUser);
		clienteService.insertCliente(c2);

		
		Cliente c3 = new Cliente();
		c3.setNombre("Carlos");
		c3.setPrimerApellido("Contrera");
		c3.setSegundoApellido("Cosentino");
		c3.setDni("33333333A");
		c3.setUpdatedUser(updatedUser);
		clienteService.insertCliente(c3);
		
		Cliente c4 = new Cliente();
		c4.setNombre("Daniela");
		c4.setPrimerApellido("Dosualdo");
		c4.setSegundoApellido("Dominguez");
		c4.setDni("44444444B");
		c4.setUpdatedUser(updatedUser);
		clienteService.insertCliente(c4);
		
		// Testeo de Método SearchByLetraDNI
		List<Cliente> lista = null;
				
		lista = clienteService.searchByLetraDNI("A");
		
		for(Cliente c : lista) {
			System.out.println(c.toString());
		}
		lista.clear();
		
		// Testeo de Método SearchByDNI
		lista = clienteService.searchByDNI("44444444B");
		
		for(Cliente c : lista) {
			System.out.println(c.toString());
		}
		lista.clear();
		

		// Testeo de Método SearchByApellidos
		lista = clienteService.searchByApellidos("Contrera", "Cosentino");
		
		for(Cliente c : lista) {
			System.out.println(c.toString());
		}
		lista.clear();

		// Cierre de sesión.
		session.close();
	}

}
