package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocacaoTest {
	
	Filme filme;
	Locacao locacao;
	Cliente cliente;

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Antes");
	}

	@After
	public void tearDown() throws Exception {
	
	}
	
	@Test
	public void testHoraDataLocacao() throws Exception {
		DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");  
		DateFormat formatoHora = new SimpleDateFormat("hh:mm:ss");  

		Date data = new Date();
		String dataAtual = formatoData.format(data);
		String horaAtual = formatoHora.format(data);
		
		locacao.alugar(cliente, filme);
		assertEquals(dataAtual, locacao.getDataLocacao());
		
		locacao.alugar(cliente, filme);
		assertEquals(horaAtual, locacao.getHoraLocacao());
	}

}
