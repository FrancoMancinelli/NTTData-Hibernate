package com.nttdata.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.services.ClienteManagementServiceI;
import com.nttdata.hibernate.services.ClienteManagementServiceImpl;

/**
 * Formaci�n - Hibernate - Taller Pr�ctio 1
 * 
 * Clase principal
 * 
 * @author Franco Emanuel Mancinelli
 *
 */
public class NTTDataMain {

	/**
	 * M�todo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesi�n.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicializaci�n de servicios.
		final ClienteManagementServiceI clienteService = new ClienteManagementServiceImpl(session);

		// Auditor�a.
		final String updatedUser = "NTT_FRANCO_M";
		
		// Creaci�n de Clientes e Inserci�n a la BD
		Cliente c1 = new Cliente();
		c1.setNombre("Antonio");
		c1.setPrimerApellido("Alvarez");
		c1.setSegundoApellido("Almiron");
		c1.setDni("11111111A");
		c1.setUpdatedUser(updatedUser);
		clienteService.insertCliente(c1);
		
		Cliente c2 = new Cliente();
		c2.setNombre("Bianca");
		c2.setPrimerApellido("Bola�o");
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
		
		// Testeo de M�todo SearchByLetraDNI
		List<Cliente> lista = null;
				
		lista = clienteService.searchByLetraDNI("A");
		
		for(Cliente c : lista) {
			System.out.println(c.toString());
		}
		lista.clear();
		
		// Testeo de M�todo SearchByDNI
		lista = clienteService.searchByDNI("44444444B");
		
		for(Cliente c : lista) {
			System.out.println(c.toString());
		}
		lista.clear();
		

		// Testeo de M�todo SearchByApellidos
		lista = clienteService.searchByApellidos("Contrera", "Cosentino");
		
		for(Cliente c : lista) {
			System.out.println(c.toString());
		}
		lista.clear();

		// Cierre de sesi�n.
		session.close();
	}

}
