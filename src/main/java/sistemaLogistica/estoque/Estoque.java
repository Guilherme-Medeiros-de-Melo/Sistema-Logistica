package sistemaLogistica.estoque;

import java.util.*;

import sistemaLogistica.pedido.Produto;

public class Estoque {

	public Estoque() {

	}

	private final Map<Produto, Integer> quantidades = new HashMap<>();

	private final Map<Produto, List<MovimentacaoEstoque>> historico = new HashMap<>();

	public void registrarEntrada(Produto produto, int quantidade) {

		validarQuantidade(quantidade);

		quantidades.merge(produto, quantidade, Integer::sum);

		registrarMovimentacao(produto, TipoMovimentacao.ENTRADA, quantidade);
	}

	public void registrarSaida(Produto produto, int quantidade) {

		validarQuantidade(quantidade);

		int estoqueAtual = quantidades.getOrDefault(produto, 0);

		if (quantidade > estoqueAtual) {
			throw new IllegalArgumentException("Estoque insuficiente.");
		}

		quantidades.put(produto, estoqueAtual - quantidade);

		registrarMovimentacao(produto, TipoMovimentacao.SAIDA, quantidade);
	}

	public int consultarQuantidade(Produto produto) {

		return quantidades.getOrDefault(produto, 0);
	}

	public List<MovimentacaoEstoque> consultarHistorico(Produto produto) {

		return historico.getOrDefault(produto, Collections.emptyList());
	}

	private void validarQuantidade(int quantidade) {

		if (quantidade <= 0) {
			throw new IllegalArgumentException("Quantidade deve ser positiva.");
		}
	}

	private void registrarMovimentacao(Produto produto, TipoMovimentacao tipo, int quantidade) {

		historico.computeIfAbsent(produto, p -> new ArrayList<>())
				.add(new MovimentacaoEstoque(produto, tipo, quantidade));
	}
}