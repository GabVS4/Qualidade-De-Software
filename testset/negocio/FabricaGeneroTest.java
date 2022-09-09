package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FabricaGeneroTest {
	GeneroFabrica factory;
	
	@Before
	public void setUp() throws Exception {
		factory = GeneroFabrica.getInstance();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInstance() {
		GeneroFabrica newFactory = GeneroFabrica.getInstance();
		assertEquals(factory, newFactory);
	}

	@Test
	public void testGetGenero() {
		Genero acao = factory.getGenero(EnumGenero.DRAMA);
		Genero comedia = factory.getGenero(EnumGenero.COMEDIA);
		Genero drama = factory.getGenero(EnumGenero.ROMANCE);
		Genero musical = factory.getGenero(EnumGenero.SIFI);
		Genero romance = factory.getGenero(EnumGenero.TERROR);
		
		assertEquals(acao.getNome(), EnumGenero.DRAMA);
		assertEquals(comedia.getNome(), EnumGenero.COMEDIA);
		assertEquals(drama.getNome(), EnumGenero.ROMANCE);
		assertEquals(musical.getNome(), EnumGenero.SIFI);
		assertEquals(romance.getNome(), EnumGenero.TERROR);
	}

}
