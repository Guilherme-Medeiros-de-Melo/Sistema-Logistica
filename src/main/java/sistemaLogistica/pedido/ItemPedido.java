package sistemaLogistica.pedido;

public class ItemPedido {

	private final Produto produto;
	private int quantidade;
	private final double precoUnitario;

	public ItemPedido(Produto produto, int quantidade, double precoUnitario) {

		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}

	public Produto getProduto() {
		return produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void adicionarQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}

	public double getValorTotal() {
		return quantidade * precoUnitario;
	}

	public double getPesoTotal() {
		return quantidade * produto.getPeso();
	}

	@Override
	public String toString() {
		return produto.getNome() + " | qtd=" + quantidade + " | valor=" + getValorTotal();
	}
}