

import java.util.Map;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class GeneroFabrica {
	private static GeneroFabrica instance = new GeneroFabrica();
	private Map<EnumGenero, Genero> mapa = new EnumMap<EnumGenero, Genero>(EnumGenero.class);

	private GeneroFabrica() {
		List<EnumGenero> listaGeneros = Arrays.asList(EnumGenero.values());

		for (EnumGenero generoEnum : listaGeneros) {
			Genero genero = new Genero(generoEnum);
			mapa.put(generoEnum, genero);
		}
	}
	
	protected static GeneroFabrica getInstance() {
		return instance;
	}
	
	protected Genero getGenero(EnumGenero generoEnum) {
		Genero genero = mapa.get(generoEnum);
		return genero;
	}

}
