package com.nttdata.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Cliente;
import com.nttdata.hibernate.persistence.Contrato;
import com.nttdata.hibernate.services.ClienteManagementServiceI;
import com.nttdata.hibernate.services.ClienteManagementServiceImpl;
import com.nttdata.hibernate.services.ContratoManagementServiceI;
import com.nttdata.hibernate.services.ContratoManagementServiceImpl;

/**
 * Formación - Hibernate - Taller Práctio 2
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
		final ContratoManagementServiceI contratoService = new ContratoManagementServiceImpl(session);

		// Auditoría.
		final String updatedUser = "NTT_FRANCO_M";

		// Creación de Clientes
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Antonio");
		cliente1.setPrimerApellido("Alvarez");
		cliente1.setSegundoApellido("Almiron");
		cliente1.setDni("11111111A");
		cliente1.setUpdatedUser(updatedUser);

		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Bianca");
		cliente2.setPrimerApellido("Bolaño");
		cliente2.setSegundoApellido(null);
		cliente2.setDni("22222222B");
		cliente2.setUpdatedUser(updatedUser);
		
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Carlos");
		cliente3.setPrimerApellido("Contrera");
		cliente3.setSegundoApellido("Cosentino");
		cliente3.setDni("33333333A");
		cliente3.setUpdatedUser(updatedUser);

		// Creación de Contratos e Inserción a la base de datos
		Contrato contrato1 = new Contrato();
		contrato1.setFechaVigencia("2020-10-03");
		contrato1.setFechaCaducidad("2022-12-31");
		contrato1.setPrecioMensual(100.00);
		contrato1.setCliente(cliente1);
		contrato1.setUpdatedUser(updatedUser);
		//Inserción
		contratoService.insertContrato(contrato1);

		Contrato contrato2 = new Contrato();
		contrato2.setFechaVigencia("2020-10-03");
		contrato2.setFechaCaducidad("2021-12-31");
		contrato2.setPrecioMensual(200.75);
		contrato2.setCliente(cliente1);
		contrato2.setUpdatedUser(updatedUser);
		//Inserción
		contratoService.insertContrato(contrato2);

		Contrato contrato3 = new Contrato();
		contrato3.setFechaVigencia("2020-10-03");
		contrato3.setFechaCaducidad("2023-06-31");
		contrato3.setPrecioMensual(300.00);
		contrato3.setCliente(cliente2);
		contrato3.setUpdatedUser(updatedUser);
		//Inserción
		contratoService.insertContrato(contrato3);

		Contrato contrato4 = new Contrato();
		contrato4.setFechaVigencia("2020-10-03");
		contrato4.setFechaCaducidad("2025-12-31");
		contrato4.setPrecioMensual(400.50);
		contrato4.setCliente(cliente2);
		contrato4.setUpdatedUser(updatedUser);
		//Inserción
		contratoService.insertContrato(contrato4);
		
		Contrato contrato5 = new Contrato();
		contrato5.setFechaVigencia("2020-10-03");
		contrato5.setFechaCaducidad("2030-01-31");
		contrato5.setPrecioMensual(599.99);
		contrato5.setCliente(cliente3);
		contrato5.setUpdatedUser(updatedUser);
		//Inserción
		contratoService.insertContrato(contrato5);
		
		// Una vez creados los contratos y asignados sus clientes
		// Los enlistamos para posteriormente asignarlos a sus repesctivos clientes
		
		// Los contratos 1 y 2, corresponden al Cliente 1
		final List<Contrato> listaContratosCliente1 = new ArrayList<>();
		listaContratosCliente1.add(contrato1);
		listaContratosCliente1.add(contrato2);
		
		// Los contratos 3 y 4, corresponden al Cliente 2
		final List<Contrato> listaContratosCliente2 = new ArrayList<>();
		listaContratosCliente2.add(contrato3);
		listaContratosCliente2.add(contrato4);
		
		// El contrato 5, corresponde al Cliente 3
		final List<Contrato> listaContratosCliente3 = new ArrayList<>();
		listaContratosCliente3.add(contrato5);
		
		// Asignamos a los Clientes su lista de contratos
		cliente1.setContratos(listaContratosCliente1);
		cliente2.setContratos(listaContratosCliente2);
		cliente3.setContratos(listaContratosCliente3);
		
		// Por último, con todos los campos definidos, agregamos los Clientes
		clienteService.insertCliente(cliente1);
		clienteService.insertCliente(cliente2);
		clienteService.insertCliente(cliente3);
		
		// Prueba de métodos Contrato
		List<Cliente> lista = null;
		lista = contratoService.searchByClienteConContratosCaducados("2022-11-23");
		
		System.out.println("\nClientes con contratos vencidos:");
		
		for(Cliente c : lista) {
			System.out.println(c.getNombre() +" "+ c.getPrimerApellido() +" "+ c.getSegundoApellido());
		}
		
		
		// Cierre de sesión.
		session.close();
	}

}
