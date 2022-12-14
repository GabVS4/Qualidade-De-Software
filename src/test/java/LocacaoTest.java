

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LocacaoTest {
	Cliente cliente;
	Filme filme;
	Locacao locacao;
	double valor;
	
	@SuppressWarnings("deprecation")
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("Gabriel", 2);
		filme = new Filme(1, "JavaLand", EnumGenero.DRAMA, 1000.00);
		locacao = new Locacao();
		valor = 20.00;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAlugarClienteFilme() throws Exception {
		locacao.alugar(cliente, filme);			
		assertEquals(locacao.getFilme(), filme);
		assertEquals(locacao.getCliente(), cliente);
		assertEquals(locacao.getValorAluguel(), 0, 0.01);
	}
	
	@Test
	public void testAlugarClienteInativoFilme() throws Exception {
		cliente.setAtivo(false);
		exception.expect(Exception.class);
		
		locacao.alugar(cliente, filme);
		assertEquals(locacao.getFilme(), null);
		assertEquals(locacao.getCliente(), null);
		assertEquals(locacao.getValorAluguel(), 20, 0.01);
	}

	@Test
	public void testGetDesconto() throws Exception {
		Filme filme2 = new Filme(1, "JavaLand", EnumGenero.ROMANCE, 1000.00);
		Cliente cliente2 = new Cliente("Gabriel", 2);
		Locacao locacao2 = new Locacao();
		
		GeneroFabrica factory = GeneroFabrica.getInstance();
		Genero romance = factory.getGenero(filme2.getGenero());

		double desconto = 0.15;
		romance.setDesconto(desconto);
		
		locacao2.alugar(cliente2, filme2);
		
		double valorComDesconto = locacao2.getDesconto(valor, filme2);
		double porcentagemDesconto = 1 - (valorComDesconto / valor);
		assertEquals(desconto, porcentagemDesconto, 0.01);
	}
	
	@Test
	public void testGetDataLocacao() throws Exception {
		DateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");  

		Date dataAtual = new Date();
		String dataAtualString = formatoData.format(dataAtual);
		
		locacao.alugar(cliente, filme);
		assertEquals(dataAtualString, locacao.getDataLocacao());
	}
}