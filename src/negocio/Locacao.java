package negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	protected double getValorAluguel() {
		return valorAluguel;
	}
	
	protected Cliente getCliente() {
		return cliente;
	}
	
	protected Filme getFilme() {
		return filme;
	}
	
	private void setFilme(Filme filme) {
		this.filme= filme;
	}
	
	
	//Implementação da Data e Hora
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
	
	//------------------------------
	
}
