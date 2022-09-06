package negocio;

public class Cliente {

	protected String nome;
	protected int id;
	protected Favorito Favorito;
	protected boolean atividade = true;
	
	public Cliente(String nome, int id, boolean atividade) {
		this.Favorito = new Favorito(this);
		this.nome= nome;
		this.id= id;
		this.atividade= atividade;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean isAtivo() {
		return atividade;
	}

	public void setAtivo(boolean ativo) {
		this.atividade = ativo;
	}
}
