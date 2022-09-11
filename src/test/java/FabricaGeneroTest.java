

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
		Genero acao = factory.getGenero(EnumGenero.SIFI);
		Genero comedia = factory.getGenero(EnumGenero.COMEDIA);
		Genero drama = factory.getGenero(EnumGenero.DRAMA);
		Genero musical = factory.getGenero(EnumGenero.TERROR);
		Genero romance = factory.getGenero(EnumGenero.ROMANCE);
		
		assertEquals(acao.getNome(), EnumGenero.SIFI);
		assertEquals(comedia.getNome(), EnumGenero.COMEDIA);
		assertEquals(drama.getNome(), EnumGenero.DRAMA);
		assertEquals(musical.getNome(), EnumGenero.TERROR);
		assertEquals(romance.getNome(), EnumGenero.ROMANCE);
	}

}