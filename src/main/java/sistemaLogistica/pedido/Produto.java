package sistemaLogistica.pedido;

public class Produto {

	private int id;
	private String nome;
	private double peso;
	private double preco;
	private String categoria;

	public Produto(int id, String nome, double peso, double preco, String categoria) {
		this.id = id;
		this.nome = nome;
		this.peso = peso;
		this.preco = preco;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getPeso() {
		return peso;
	}

	public String getCategoria() {
		return categoria;
	}

	public double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return "Produto{" + "id=" + id + ", nome='" + nome + '\'' + ", peso=" + peso + ", preco=" + preco
				+ ", categoria='" + categoria + '\'' + '}';
	}
}