package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	Cliente cliente;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCliente() {
		int id = 2;
		String nome = "Gabriel";
		
		cliente = new Cliente(nome, id);
		assertEquals(id, cliente.getId());
		assertEquals(nome, cliente.getNome());
	}

}
