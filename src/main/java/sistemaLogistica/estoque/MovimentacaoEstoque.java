package sistemaLogistica.estoque;

import java.time.LocalDateTime;

import sistemaLogistica.pedido.Produto;

public class MovimentacaoEstoque {

	private final Produto produto;
	private final TipoMovimentacao tipo;
	private final int quantidade;
	private final LocalDateTime data;

	public MovimentacaoEstoque(Produto produto, TipoMovimentacao tipo, int quantidade) {

		this.produto = produto;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.data = LocalDateTime.now();
	}

	public Produto getProduto() {
		return produto;
	}

	@Override
	public String toString() {
		return String.format("%s - %s - %d unidades - %s", produto.getNome(), tipo, quantidade, data);
	}
}