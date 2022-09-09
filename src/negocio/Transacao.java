package negocio;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public final class Transacao {
	public ArrayList<Locacao> locacoes;
	private static Transacao instance = null;
	
	private Transacao() {
		locacoes = new ArrayList<Locacao>();
	}
	
	public static Transacao getInstance() {
		if (instance == null) {
			instance = new Transacao();
		}
		
		return instance;
	}
	
	public double getValorLocacaoTotal() {
		double total = 0;
		
		for (Locacao locacao : locacoes) {
			double valorAluguelFilme = locacao.getValorAluguel();
			total += valorAluguelFilme;
		}
		
		return total;
	}
	
	public double getLucroFilme(Filme filme) {
		double valorArrecadacaoFilme = 0;
		
		for (Locacao locacao : locacoes) {
			Filme filmeLocado = locacao.getFilme();
			if (filme.getId() != filmeLocado.getId()) continue;

			double valorLocacaoFilme = locacao.getValorAluguel();
			filme = filmeLocado;
			valorArrecadacaoFilme += valorLocacaoFilme;
		}
		
		double valorCompraFilme = filme.getValor();
		double lucro = (valorArrecadacaoFilme / valorCompraFilme) * 100;
		return lucro;
	}
	
	public Map<EnumGenero, Integer> getLocacoesPorGenero() {
		Map<EnumGenero, Integer> mapa = new EnumMap<EnumGenero, Integer>(EnumGenero.class);
		
		for (Locacao locacao : locacoes) {
			Filme filmeLocado = locacao.getFilme();
			EnumGenero generoFilmeLocado = filmeLocado.getGenero();
			
			Integer aparicoes = mapa.get(generoFilmeLocado);
			
			if (aparicoes == null) {
				aparicoes = 0;
			}
			
			mapa.put(generoFilmeLocado, aparicoes + 1);
		}
		
		return mapa;
	}
	
}
