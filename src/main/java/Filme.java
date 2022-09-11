

public class Filme {

	protected String nome;
	protected int id;
	protected double valorCompra;
	protected EnumGenero genero;

	public Filme(String nome, EnumGenero genero) {
		this.nome = nome;
		this.genero = genero;
	}
	
	public Filme(int id, String nome, EnumGenero genero, double valor) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.valorCompra = valor;
	}
	
	public Filme(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valorCompra;
	}

	public void setValor(double valor) {
		this.valorCompra = valor;
	}

	public EnumGenero getGenero() {
		return genero;
	}

	public void setGenero(EnumGenero genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorCompra);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if (genero != other.genero)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(valorCompra) != Double.doubleToLongBits(other.valorCompra))
			return false;
		return true;
	}

}
