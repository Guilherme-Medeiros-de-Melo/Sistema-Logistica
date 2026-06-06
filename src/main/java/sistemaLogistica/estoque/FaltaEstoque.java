package sistemaLogistica.estoque;

import sistemaLogistica.pedido.Produto;

public class FaltaEstoque {

	private final Produto produto;
	private final int quantidadeSolicitada;
	private final int quantidadeDisponivel;

	public FaltaEstoque(Produto produto, int quantidadeSolicitada, int quantidadeDisponivel) {

		this.produto = produto;
		this.quantidadeSolicitada = quantidadeSolicitada;
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public int getQuantidadeFaltante() {
		return quantidadeSolicitada - quantidadeDisponivel;
	}

	@Override
	public String toString() {
		return produto.getNome() + " - faltam " + getQuantidadeFaltante() + " unidades";
	}
}