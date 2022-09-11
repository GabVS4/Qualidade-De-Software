

import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected double valorAluguel;
	protected Date data;
	
	public void alugar(Cliente c, Filme f, double valor) {
		if(c.atividade = true) {
			this.cliente = c;
			this.filme = f;
			this.setDataAtual();
		}System.out.println("Cliente Inativo!!!");
	}
	
	protected void alugar(Cliente cliente, Filme filme) throws Exception {
		this.setCliente(cliente);
		this.setFilme(filme);
		this.setDataAtual();
	}
	
	protected double getDesconto(double valor, Filme filme) {
		GeneroFabrica factory = GeneroFabrica.getInstance();

		EnumGenero generoEnum = filme.getGenero();
		Genero genero = factory.getGenero(generoEnum);
		
		double desconto = genero.getDesconto();
		return (1 - desconto) * valor;
	}
	
	protected double getValorAluguel() {
		return valorAluguel;
	}
	
	protected void setValorAluguel(double valor) {
		double valorComDesconto = getDesconto(valor, filme);
		this.valorAluguel = valorComDesconto;
	}
	
	protected Cliente getCliente() {
		return cliente;
	}
	
	private void setCliente(Cliente cliente) throws Exception {
		if (cliente.isAtivo() == false) {
			throw new Exception("Cliente should be active to perform this operation");
		}
		
		this.cliente = cliente;
	}
	
	protected Filme getFilme() {
		return filme;
	}
	
	private void setFilme(Filme filme) {
		this.filme= filme;
	}
	
	protected Date getData() {
		return data;
	}
	
	protected void setData (Date data) {
		this.data = data;
	}
	
	protected String getDataLocacao() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String Data = dateFormat.format(getData());
		return Data;
	}
	
	protected String getHoraLocacao() {
		DateFormat hourFormat = new SimpleDateFormat("hh:mm:ss");  
		String Data = hourFormat.format(getData());
		return Data;		
	}
	
	protected void setDataAtual() {
		setData(new Date());
	}
	
}
