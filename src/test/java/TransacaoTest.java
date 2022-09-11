

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TransacaoTest {
	Transacao transacao;
	Filme filme;
	Cliente cliente, cliente2;
	Locacao locacao, locacao2; 
	
	@Before
	public void setUp() throws Exception {
		transacao = Transacao.getInstance();
		filme = new Filme(1, "JavaScript e Java - A Batalha Final", EnumGenero.COMEDIA, 2000.00);

		cliente = new Cliente("Gab",1);
		cliente2 = new Cliente("Jul",2);
		
		locacao = new Locacao();
		locacao2 = new Locacao();		
	
		locacao.alugar(cliente, filme, 20.00);
		locacao2.alugar(cliente2, filme, 20.00);

		transacao.locacoes.add(locacao);
		transacao.locacoes.add(locacao2);
	}

	@After
	public void tearDown() throws Exception {
		transacao.locacoes.clear();
	}

	@Test
	public void testGetInstance() {
		Transacao transacao2 = Transacao.getInstance();
		assertEquals(transacao, transacao2);
	}

	@Test
	public void testGetValorLocacaoTotal() {
		double valorLocacaoTotal = transacao.getValorLocacaoTotal();
		assertEquals(40.00, valorLocacaoTotal, 0.01);
	}

	@Test
	public void testGetLucroFilme() {		
		Filme filmeAuxiliar = new Filme(filme.getId());
		double lucroFilme = transacao.getLucroFilme(filmeAuxiliar);
		assertEquals(2, lucroFilme, 0.01);
	}

	@Test
	public void testGetLocacoesPorGenero() throws Exception {
		Locacao locacao3 = new Locacao();
		Locacao locacao4 = new Locacao();
		
		Filme filmeLocacao3 = new Filme("Um dia na Javalândia", EnumGenero.SIFI);
		Filme filmeLocacao4 = new Filme("C# versus Java - A batalha do século", EnumGenero.DRAMA);

		Cliente cliente3 = new Cliente("Marcos",3);
		Cliente cliente4 = new Cliente("Gabriel",3);
		
		locacao3.alugar(cliente3, filmeLocacao3);
		locacao4.alugar(cliente4, filmeLocacao4, 0);
		
		transacao.locacoes.add(locacao3);
		transacao.locacoes.add(locacao4);
		
		Map<EnumGenero, Integer> mapa = transacao.getLocacoesPorGenero();
		
		Integer locacoesAcao = mapa.get(EnumGenero.DRAMA);
		Integer locacoesComedia = mapa.get(EnumGenero.ROMANCE);
		Integer locacoesDrama = mapa.get(EnumGenero.COMEDIA);
		Integer locacoesMusical = mapa.get(EnumGenero.SIFI);
		Integer locacoesRomance = mapa.get(EnumGenero.TERROR);
		
		assertTrue(locacoesAcao == 1);
		assertTrue(locacoesComedia == null);
		assertTrue(locacoesDrama == null);
		assertTrue(locacoesMusical == 1);
		assertTrue(locacoesRomance == null);
	}
}