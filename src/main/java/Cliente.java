

public class Cliente {

	protected String nome;
	protected int id;
	protected Favorito Favorito;
	protected boolean atividade = true;
	
	public Cliente(String nome, int id) {
		this.nome= nome;
		this.id= id;
		this.Favorito = new Favorito(this);
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
